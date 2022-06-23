package com.dhybrid.admin.request;

import java.util.HashSet;
import java.util.Set;

import com.dhybrid.admin.models.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRequest {

	String userId;
	String fullName;
	String email;
	String password;
	String mobileNumber;
	@JsonIgnore
	String mobileOTP;
	String otpValidTill;
	String userAccountSource;
	String referralCode;
	String accountStatus;
	String profilePicture;
	String ageGroup;
	String dateOfBirth;
	String gender;
	String userLocation;
	String deviceLatitude;
	String deviceLongitude;
	String deviceOS;
	String userCategoryTag;
	String lastLogin;
	String accountCreated;
	String accountUpdated;
	String accountDeleted;
	String provider;
	Set<Role> roles = new HashSet<>();
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the mobileOTP
	 */
	public String getMobileOTP() {
		return mobileOTP;
	}
	/**
	 * @param mobileOTP the mobileOTP to set
	 */
	public void setMobileOTP(String mobileOTP) {
		this.mobileOTP = mobileOTP;
	}
	/**
	 * @return the otpValidTill
	 */
	public String getOtpValidTill() {
		return otpValidTill;
	}
	/**
	 * @param otpValidTill the otpValidTill to set
	 */
	public void setOtpValidTill(String otpValidTill) {
		this.otpValidTill = otpValidTill;
	}
	/**
	 * @return the userAccountSource
	 */
	public String getUserAccountSource() {
		return userAccountSource;
	}
	/**
	 * @param userAccountSource the userAccountSource to set
	 */
	public void setUserAccountSource(String userAccountSource) {
		this.userAccountSource = userAccountSource;
	}
	/**
	 * @return the referralCode
	 */
	public String getReferralCode() {
		return referralCode;
	}
	/**
	 * @param referralCode the referralCode to set
	 */
	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}
	/**
	 * @return the accountStatus
	 */
	public String getAccountStatus() {
		return accountStatus;
	}
	/**
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}
	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	/**
	 * @return the ageGroup
	 */
	public String getAgeGroup() {
		return ageGroup;
	}
	/**
	 * @param ageGroup the ageGroup to set
	 */
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the userLocation
	 */
	public String getUserLocation() {
		return userLocation;
	}
	/**
	 * @param userLocation the userLocation to set
	 */
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	/**
	 * @return the deviceLatitude
	 */
	public String getDeviceLatitude() {
		return deviceLatitude;
	}
	/**
	 * @param deviceLatitude the deviceLatitude to set
	 */
	public void setDeviceLatitude(String deviceLatitude) {
		this.deviceLatitude = deviceLatitude;
	}
	/**
	 * @return the deviceLongitude
	 */
	public String getDeviceLongitude() {
		return deviceLongitude;
	}
	/**
	 * @param deviceLongitude the deviceLongitude to set
	 */
	public void setDeviceLongitude(String deviceLongitude) {
		this.deviceLongitude = deviceLongitude;
	}
	/**
	 * @return the deviceOS
	 */
	public String getDeviceOS() {
		return deviceOS;
	}
	/**
	 * @param deviceOS the deviceOS to set
	 */
	public void setDeviceOS(String deviceOS) {
		this.deviceOS = deviceOS;
	}
	/**
	 * @return the userCategoryTag
	 */
	public String getUserCategoryTag() {
		return userCategoryTag;
	}
	/**
	 * @param userCategoryTag the userCategoryTag to set
	 */
	public void setUserCategoryTag(String userCategoryTag) {
		this.userCategoryTag = userCategoryTag;
	}
	/**
	 * @return the lastLogin
	 */
	public String getLastLogin() {
		return lastLogin;
	}
	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	/**
	 * @return the accountCreated
	 */
	public String getAccountCreated() {
		return accountCreated;
	}
	/**
	 * @param accountCreated the accountCreated to set
	 */
	public void setAccountCreated(String accountCreated) {
		this.accountCreated = accountCreated;
	}
	/**
	 * @return the accountUpdated
	 */
	public String getAccountUpdated() {
		return accountUpdated;
	}
	/**
	 * @param accountUpdated the accountUpdated to set
	 */
	public void setAccountUpdated(String accountUpdated) {
		this.accountUpdated = accountUpdated;
	}
	/**
	 * @return the accountDeleted
	 */
	public String getAccountDeleted() {
		return accountDeleted;
	}
	/**
	 * @param accountDeleted the accountDeleted to set
	 */
	public void setAccountDeleted(String accountDeleted) {
		this.accountDeleted = accountDeleted;
	}
	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}
	/**
	 * @param provider the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}
	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
