package com.hrms.karcan.business.adapters;

import java.rmi.RemoteException;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.hrms.karcan.business.abstracts.IdentityValidationService;
import com.hrms.karcan.core.utilities.result.ErrorResult;
import com.hrms.karcan.core.utilities.result.Result;
import com.hrms.karcan.core.utilities.result.SuccessResult;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements IdentityValidationService {

	@Override
	public Result checkIdentityNumber(String identityNumber, String firstName, String lastName, Date birthDate) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result = true;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(birthDate.getTime()); 
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(
					Long.parseLong(identityNumber),
					firstName.toUpperCase(),
					lastName.toUpperCase(), 
					calendar.get(Calendar.YEAR)
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

}
