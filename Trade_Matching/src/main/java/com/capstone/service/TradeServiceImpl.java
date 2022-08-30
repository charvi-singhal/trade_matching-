package com.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.models.PartyValidationModel;
import com.capstone.models.TradeDataModel;
import com.capstone.repo.TradeRepo;
import com.capstone.repo.ValidationRepo;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepo tradeRepository;
	@Autowired
	private ValidationRepo ValidationRepository;

	@Override
	public List<TradeDataModel> getAllTrade() {
		// TODO Auto-generated method stub
		return tradeRepository.findAll();
	}

	@Override
	public TradeDataModel insertTrade(TradeDataModel td) {
		int checkDate = 0, validTRN = 0, validBuyerSeller = 0, validPartyAndCParty = 0;

		// tradeRefNum = Party + TradeId
		td.setTradeRefNum(td.getParty(), td.getTradeId());

		// finding if tradeRefNum already exists or not
		TradeDataModel td1 = tradeRepository.findByTradeRefNum(td.getTradeRefNum());
		if (td1 == null) {
			validTRN = 1;
		}

		// setting version = 1 at the time of insertion
		td.setVersion(1);

		// setting status = unconfirmed at the time of insertion
		td.setStatus("Unconfirmed");

		// party and counterParty validation
		PartyValidationModel pvm = ValidationRepository.findByPartyAndPartyInstitutionAndPartyFullName(td.getParty(),
				td.getPartyInstitution(), td.getPartyFullname());

		PartyValidationModel cpvm = ValidationRepository.findByPartyAndPartyInstitutionAndPartyFullName(
				td.getCounterParty(), td.getCounterPartyInstitution(), td.getCounterPartyFullname());

		if (pvm != null && cpvm != null) {
			validPartyAndCParty = 1;
		}

		// seller and buyer can not be same
		if (td.getBuyer() != td.getSeller()) {
			validBuyerSeller = 1;
		}

		//tradeDate <= effectiveDate <= maturityDate 
		if (td.getEffectiveDate().compareTo(td.getTradeDate()) >= 0) {
			if (td.getMaturityDate().compareTo(td.getEffectiveDate()) >= 0) {
				checkDate = 1;
			}
		}

		if (validTRN == 1 && checkDate == 1 && validBuyerSeller == 1 && validPartyAndCParty == 1) {
			return tradeRepository.save(td);
		}
		else {
		return null;
		}
	}

}
