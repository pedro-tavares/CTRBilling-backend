package com.javalabs.billing;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.javalabs.config.ConfigFactory;

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
	private String CallDate;
	private String CallTime;
	private String Duration;
	private String BytesTransmitted;
	private String BytesReceived;
	private String Description;
	private String Chargecode;
	private String TimeBand;
	private String Salesprice;
	private String SalespricePreBundle;
	private String Extension;
	private String DDI;
	private String GroupingID;
	private String CallClass;
	private String Carrier;
	private String Recording;
	private String VAT;
	private String CountryOfOrigin;
	private String Network;
	private String RetailTariffCode;
	private String RemoteNetwork;
	private String APN;
	private String DivertedNumber;
	private String RingTime;
	private String RecordID;
	private String Currency;
	private String PresentationNumber;
	private String NetworkAccessReference;
	private String NGCSAccessCharge;
	private String NGCSServiceCharge;
	private String TotalBytesTransferred;
	private String UserID;
	private String OnwardBillingReference;
	private String ContractName;
	private String BundleName;
	private String BundleAllowance;
	private String DiscountReference;
	private String RoutingCode;

	public BillingRecordEntity() {}

	public BillingRecordEntity(Object id, String callType, String callCause, String customerIdentifir,
			String telephoneNumberDialled, String callDate, String callTime, String duration, String bytesTransmitted,
			String bytesReceived, String description, String chargecode, String timeBand, String salesprice,
			String salespricePreBundle, String extension, String dDI, String groupingID, String callClass,
			String carrier, String recording, String vAT, String countryOfOrigin, String network,
			String retailTariffCode, String remoteNetwork, String aPN, String divertedNumber, String ringTime,
			String recordID, String currency, String presentationNumber, String networkAccessReference,
			String nGCSAccessCharge, String nGCSServiceCharge, String totalBytesTransferred, String userID,
			String onwardBillingReference, String contractName, String bundleName, String bundleAllowance,
			String discountReference, String routingCode) {
		
		super();
		
		this.id = null;//id;
		CallType = callType;
		CallCause = callCause;
		CustomerIdentifir = customerIdentifir;
		TelephoneNumberDialled = telephoneNumberDialled;
		CallDate = callDate;
		CallTime = callTime;
		Duration = duration;
		BytesTransmitted = bytesTransmitted;
		BytesReceived = bytesReceived;
		Description = description;
		Chargecode = chargecode;
		TimeBand = timeBand;
		Salesprice = salesprice;
		SalespricePreBundle = salespricePreBundle;
		Extension = extension;
		DDI = dDI;
		GroupingID = groupingID;
		CallClass = callClass;
		Carrier = carrier;
		Recording = recording;
		VAT = vAT;
		CountryOfOrigin = countryOfOrigin;
		Network = network;
		RetailTariffCode = retailTariffCode;
		RemoteNetwork = remoteNetwork;
		APN = aPN;
		DivertedNumber = divertedNumber;
		RingTime = ringTime;
		RecordID = recordID;
		Currency = currency;
		PresentationNumber = presentationNumber;
		NetworkAccessReference = networkAccessReference;
		NGCSAccessCharge = nGCSAccessCharge;
		NGCSServiceCharge = nGCSServiceCharge;
		TotalBytesTransferred = totalBytesTransferred;
		UserID = userID;
		OnwardBillingReference = onwardBillingReference;
		ContractName = contractName;
		BundleName = bundleName;
		BundleAllowance = bundleAllowance;
		DiscountReference = discountReference;
		RoutingCode = routingCode;
	}

	public BillingRecordEntity(Long id, String string1, String string2, String string3, String string4,
			String string5, String string6, String string7, String string8, String string9, String string10,
			String string11, String string12, String string13, String string14, String string15, String string16,
			String string17, String string18, String string19, String string20, String string21, String string22,
			String string23, String string24, String string25, String string26, String string27, String string28,
			String string29, String string30, String string31, String string32, String string33, String string34,
			String string35, String string36, String string37, String string38, String string39, String string40,
			String string41, String string42) {

		this.id = id;
		CallType = string1;
		CallCause = string2;
		CustomerIdentifir = string3;
		TelephoneNumberDialled = string4;
		CallDate = string5;
		CallTime = string6;
		Duration = string7;
		BytesTransmitted = string8;
		BytesReceived = string9;
		Description = string10;
		Chargecode = string11;
		TimeBand = string12;
		Salesprice = string13;
		SalespricePreBundle = string14;
		Extension = string15;
		DDI = string16;
		GroupingID = string17;
		CallClass = string18;
		Carrier = string19;
		Recording = string20;
		VAT = string21;
		CountryOfOrigin = string22;
		Network = string23;
		RetailTariffCode = string24;
		RemoteNetwork = string25;
		APN = string26;
		DivertedNumber = string27;
		RingTime = string28;
		RecordID = string29;
		Currency = string30;
		PresentationNumber = string31;
		NetworkAccessReference = string32;
		NGCSAccessCharge = string33;
		NGCSServiceCharge = string34;
		TotalBytesTransferred = string35;
		UserID = string36;
		OnwardBillingReference = string37;
		ContractName = string38;
		BundleName = string39;
		BundleAllowance = string40;
		DiscountReference = string41;
		RoutingCode = string42;
	}

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

	public String getCallDate() {
		return CallDate;
	}

	public void setCallDate(String callDate) {
		CallDate = callDate;
	}

	public String getCallTime() {
		return CallTime;
	}

	public void setCallTime(String callTime) {
		CallTime = callTime;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public String getBytesTransmitted() {
		return BytesTransmitted;
	}

	public void setBytesTransmitted(String bytesTransmitted) {
		BytesTransmitted = bytesTransmitted;
	}

	public String getBytesReceived() {
		return BytesReceived;
	}

	public void setBytesReceived(String bytesReceived) {
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

	public String getSalesprice() {
		return Salesprice;
	}

	public void setSalesprice(String salesprice) {
		Salesprice = salesprice;
	}

	public String getSalespricePreBundle() {
		return SalespricePreBundle;
	}

	public void setSalespricePreBundle(String salespricePreBundle) {
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

	public String getVAT() {
		return VAT;
	}

	public void setVAT(String vAT) {
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

	public String getRingTime() {
		return RingTime;
	}

	public void setRingTime(String ringTime) {
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

	public String getTotalBytesTransferred() {
		return TotalBytesTransferred;
	}

	public void setTotalBytesTransferred(String totalBytesTransferred) {
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
