package com.hrms.karcan.business.adapters;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.IdentityValidationService;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements IdentityValidationService{
	
	@Override
	public Result CheckIfRealPerson(Long identityNumber, String firstName, String lastName, int birthYear) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result = true;
		
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(
					identityNumber,
					firstName.toUpperCase(),
					lastName.toUpperCase(), 
					birthYear 
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(result) {
			return new SuccessResult();
		}else {
			return new ErrorResult(firstName.toUpperCase() + " " + lastName.toUpperCase() + " : Kimlik doğrulama başarısız.");
		}
			
	}
	
	/*
	 * For a `String` identityNumber
	 * */
	@Override
	public Result CheckIfRealPerson(String identityNumber, String firstName, String lastName, Date birthDate) {
		return this.CheckIfRealPerson(
				Long.parseLong(identityNumber), 
				firstName, 
				lastName, 
				birthDate
				);
	}	
	/*
	 * For a `Date` birthDate
	 * */
	@Override
	public Result CheckIfRealPerson(Long identityNumber, String firstName, String lastName, Date birthDate) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(birthDate.getTime());
		return this.CheckIfRealPerson(
				identityNumber, 
				firstName, 
				lastName, 
				calendar.get(Calendar.YEAR)
				);
	}


}
