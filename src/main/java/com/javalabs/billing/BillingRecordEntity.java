package com.javalabs.billing;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing_record")
public class BillingRecordEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String CallType;
	private String CallCause;
	private String CustomerIdentifir;
	private String TelephoneNumberDialled;
	private Date CallDate;
	private String CallTime;
	private Integer Duration;
	private Integer BytesTransmitted;
	private Integer BytesReceived;
	private String Description;
	private String Chargecode;
	private String TimeBand;
	private BigDecimal Salesprice;
	private BigDecimal SalespricePreBundle;
	private String Extension;
	private String DDI;
	private String GroupingID;
	private String CallClass;
	private String Carrier;
	private String Recording;
	private Float VAT;
	private String CountryOfOrigin;
	private String Network;
	private String RetailTariffCode;
	private String RemoteNetwork;
	private String APN;
	private String DivertedNumber;
	private Date RingTime;
	private String RecordID;
	private String Currency;
	private String PresentationNumber;
	private String NetworkAccessReference;
	private String NGCSAccessCharge;
	private String NGCSServiceCharge;
	private Integer TotalBytesTransferred;
	private String UserID;
	private String OnwardBillingReference;
	private String ContractName;
	private String BundleName;
	private String BundleAllowance;
	private String DiscountReference;
	private String RoutingCode;

	public BillingRecordEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCallType() {
		return CallType;
	}

	public void setCallType(String callType) {
		CallType = callType;
	}

	public String getCallCause() {
		return CallCause;
	}

	public void setCallCause(String callCause) {
		CallCause = callCause;
	}

	public String getCustomerIdentifir() {
		return CustomerIdentifir;
	}

	public void setCustomerIdentifir(String customerIdentifir) {
		CustomerIdentifir = customerIdentifir;
	}

	public String getTelephoneNumberDialled() {
		return TelephoneNumberDialled;
	}

	public void setTelephoneNumberDialled(String telephoneNumberDialled) {
		TelephoneNumberDialled = telephoneNumberDialled;
	}

	public Date getCallDate() {
		return CallDate;
	}

	public void setCallDate(Date callDate) {
		CallDate = callDate;
	}

	public String getCallTime() {
		return CallTime;
	}

	public void setCallTime(String callTime) {
		CallTime = callTime;
	}

	public Integer getDuration() {
		return Duration;
	}

	public void setDuration(Integer duration) {
		Duration = duration;
	}

	public Integer getBytesTransmitted() {
		return BytesTransmitted;
	}

	public void setBytesTransmitted(Integer bytesTransmitted) {
		BytesTransmitted = bytesTransmitted;
	}

	public Integer getBytesReceived() {
		return BytesReceived;
	}

	public void setBytesReceived(Integer bytesReceived) {
		BytesReceived = bytesReceived;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getChargecode() {
		return Chargecode;
	}

	public void setChargecode(String chargecode) {
		Chargecode = chargecode;
	}

	public String getTimeBand() {
		return TimeBand;
	}

	public void setTimeBand(String timeBand) {
		TimeBand = timeBand;
	}

	public BigDecimal getSalesprice() {
		return Salesprice;
	}

	public void setSalesprice(BigDecimal salesprice) {
		Salesprice = salesprice;
	}

	public BigDecimal getSalespricePreBundle() {
		return SalespricePreBundle;
	}

	public void setSalespricePreBundle(BigDecimal salespricePreBundle) {
		SalespricePreBundle = salespricePreBundle;
	}

	public String getExtension() {
		return Extension;
	}

	public void setExtension(String extension) {
		Extension = extension;
	}

	public String getDDI() {
		return DDI;
	}

	public void setDDI(String dDI) {
		DDI = dDI;
	}

	public String getGroupingID() {
		return GroupingID;
	}

	public void setGroupingID(String groupingID) {
		GroupingID = groupingID;
	}

	public String getCallClass() {
		return CallClass;
	}

	public void setCallClass(String callClass) {
		CallClass = callClass;
	}

	public String getCarrier() {
		return Carrier;
	}

	public void setCarrier(String carrier) {
		Carrier = carrier;
	}

	public String getRecording() {
		return Recording;
	}

	public void setRecording(String recording) {
		Recording = recording;
	}

	public Float getVAT() {
		return VAT;
	}

	public void setVAT(Float vAT) {
		VAT = vAT;
	}

	public String getCountryOfOrigin() {
		return CountryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		CountryOfOrigin = countryOfOrigin;
	}

	public String getNetwork() {
		return Network;
	}

	public void setNetwork(String network) {
		Network = network;
	}

	public String getRetailTariffCode() {
		return RetailTariffCode;
	}

	public void setRetailTariffCode(String retailTariffCode) {
		RetailTariffCode = retailTariffCode;
	}

	public String getRemoteNetwork() {
		return RemoteNetwork;
	}

	public void setRemoteNetwork(String remoteNetwork) {
		RemoteNetwork = remoteNetwork;
	}

	public String getAPN() {
		return APN;
	}

	public void setAPN(String aPN) {
		APN = aPN;
	}

	public String getDivertedNumber() {
		return DivertedNumber;
	}

	public void setDivertedNumber(String divertedNumber) {
		DivertedNumber = divertedNumber;
	}

	public Date getRingTime() {
		return RingTime;
	}

	public void setRingTime(Date ringTime) {
		RingTime = ringTime;
	}

	public String getRecordID() {
		return RecordID;
	}

	public void setRecordID(String recordID) {
		RecordID = recordID;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getPresentationNumber() {
		return PresentationNumber;
	}

	public void setPresentationNumber(String presentationNumber) {
		PresentationNumber = presentationNumber;
	}

	public String getNetworkAccessReference() {
		return NetworkAccessReference;
	}

	public void setNetworkAccessReference(String networkAccessReference) {
		NetworkAccessReference = networkAccessReference;
	}

	public String getNGCSAccessCharge() {
		return NGCSAccessCharge;
	}

	public void setNGCSAccessCharge(String nGCSAccessCharge) {
		NGCSAccessCharge = nGCSAccessCharge;
	}

	public String getNGCSServiceCharge() {
		return NGCSServiceCharge;
	}

	public void setNGCSServiceCharge(String nGCSServiceCharge) {
		NGCSServiceCharge = nGCSServiceCharge;
	}

	public Integer getTotalBytesTransferred() {
		return TotalBytesTransferred;
	}

	public void setTotalBytesTransferred(Integer totalBytesTransferred) {
		TotalBytesTransferred = totalBytesTransferred;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getOnwardBillingReference() {
		return OnwardBillingReference;
	}

	public void setOnwardBillingReference(String onwardBillingReference) {
		OnwardBillingReference = onwardBillingReference;
	}

	public String getContractName() {
		return ContractName;
	}

	public void setContractName(String contractName) {
		ContractName = contractName;
	}

	public String getBundleName() {
		return BundleName;
	}

	public void setBundleName(String bundleName) {
		BundleName = bundleName;
	}

	public String getBundleAllowance() {
		return BundleAllowance;
	}

	public void setBundleAllowance(String bundleAllowance) {
		BundleAllowance = bundleAllowance;
	}

	public String getDiscountReference() {
		return DiscountReference;
	}

	public void setDiscountReference(String discountReference) {
		DiscountReference = discountReference;
	}

	public String getRoutingCode() {
		return RoutingCode;
	}

	public void setRoutingCode(String routingCode) {
		RoutingCode = routingCode;
	}
	
}
