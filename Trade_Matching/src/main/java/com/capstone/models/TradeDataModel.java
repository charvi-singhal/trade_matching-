package com.capstone.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;



@Entity

public class TradeDataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false ,columnDefinition = "varchar(20)")
	
	private String party;
	
	
	@Column(nullable=false ,columnDefinition = "varchar(20)")
	
	private String tradeId; 
	
	@Column(nullable=false ,columnDefinition = "varchar(20)",unique = true)
	private String tradeRefNum=party+tradeId;
	
	@Column(nullable=false ,columnDefinition = "varchar(20)")
	
	private String partyInstitution;
	
	@Column(nullable=false,columnDefinition = "varchar(20)")
	
	private String counterParty;
	
	@Column(nullable = false ,columnDefinition = "varchar(20)")
	
	private String counterPartyInstitution;
	
	@Column(nullable = false,columnDefinition = "varchar(200)")
	
	private String partyFullname;
	
	@Column(nullable = false,columnDefinition = "varchar(200)")
	
	private String counterPartyFullname;
	
	@Temporal(value=TemporalType.DATE)
	private java.util.Date tradeDate;
	
	@Temporal(value=TemporalType.DATE)
	private java.util.Date effectiveDate;
	
	@Column(nullable = false,columnDefinition = "varchar(40)")
	private String InstrumentId;
	
	@Column(nullable = false)
	private double notionalAmount;
	
	@Temporal(value=TemporalType.DATE)
	private java.util.Date maturityDate;
	
	@Column(nullable = false)
	private String currency;
	
	@Column(nullable = false)
	private String seller;
	
	@Column(nullable = false)
	private String buyer;
	
	
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private java.util.Date versionTimestamp;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private java.util.Date confirmationTimestamp;
	

	@Column(columnDefinition = "INT DEFAULT '1'",insertable = false,nullable = false)
	@ApiModelProperty(example = "1")
	private int version;
	
	@Column(nullable = false,insertable = false,columnDefinition = "VARCHAR(40) DEFAULT 'Unconfirmed'")
	@ApiModelProperty(example = "Unconfirmed")
	private String status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParty() {
		return party;
	}

	public TradeDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradeDataModel(Long id, String party, String tradeId, String tradeRefNum, String partyInstitution,
			String counterParty, String counterPartyInstitution, String partyFullname, String counterPartyFullname,
			java.util.Date tradeDate, java.util.Date effectiveDate, String instrumentId, double notionalAmount,
			java.util.Date maturityDate, String currency, String seller, String buyer, java.util.Date versionTimestamp,
			java.util.Date confirmationTimestamp, int version, String status) {
		super();
		this.id = id;
		this.party = party;
		this.tradeId = tradeId;
		this.tradeRefNum = tradeRefNum;
		this.partyInstitution = partyInstitution;
		this.counterParty = counterParty;
		this.counterPartyInstitution = counterPartyInstitution;
		this.partyFullname = partyFullname;
		this.counterPartyFullname = counterPartyFullname;
		this.tradeDate = tradeDate;
		this.effectiveDate = effectiveDate;
		InstrumentId = instrumentId;
		this.notionalAmount = notionalAmount;
		this.maturityDate = maturityDate;
		this.currency = currency;
		this.seller = seller;
		this.buyer = buyer;
		this.versionTimestamp = versionTimestamp;
		this.confirmationTimestamp = confirmationTimestamp;
		this.version = version;
		this.status = status;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getTradeRefNum() {
		return tradeRefNum;
	}

	public void setTradeRefNum(String party,String tradeId) {
		this.tradeRefNum = party+tradeId;
	}

	public String getPartyInstitution() {
		return partyInstitution;
	}

	public void setPartyInstitution(String partyInstitution) {
		this.partyInstitution = partyInstitution;
	}

	public String getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}

	public String getCounterPartyInstitution() {
		return counterPartyInstitution;
	}

	public void setCounterPartyInstitution(String counterPartyInstitution) {
		this.counterPartyInstitution = counterPartyInstitution;
	}

	public String getPartyFullname() {
		return partyFullname;
	}

	public void setPartyFullname(String partyFullname) {
		this.partyFullname = partyFullname;
	}

	public String getCounterPartyFullname() {
		return counterPartyFullname;
	}

	public void setCounterPartyFullname(String counterPartyFullname) {
		this.counterPartyFullname = counterPartyFullname;
	}

	public java.util.Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(java.util.Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public java.util.Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(java.util.Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getInstrumentId() {
		return InstrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		InstrumentId = instrumentId;
	}

	public double getNotionalAmount() {
		return notionalAmount;
	}

	public void setNotionalAmount(double notionalAmount) {
		this.notionalAmount = notionalAmount;
	}

	public java.util.Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(java.util.Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public java.util.Date getVersionTimestamp() {
		return versionTimestamp;
	}

	public void setVersionTimestamp(java.util.Date versionTimestamp) {
		this.versionTimestamp = versionTimestamp;
	}

	public java.util.Date getConfirmationTimestamp() {
		return confirmationTimestamp;
	}

	public void setConfirmationTimestamp(java.util.Date confirmationTimestamp) {
		this.confirmationTimestamp = confirmationTimestamp;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
}
