package com.capstone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.models.TradeDataModel;

@Service
public interface TradeService {

	List<TradeDataModel> getAllTrade();

	TradeDataModel insertTrade(TradeDataModel td);
}
