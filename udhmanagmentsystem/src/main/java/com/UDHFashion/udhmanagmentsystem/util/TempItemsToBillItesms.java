package com.UDHFashion.udhmanagmentsystem.util;

import org.springframework.stereotype.Service;

import com.UDHFashion.udhmanagmentsystem.model.Billitems;
import com.UDHFashion.udhmanagmentsystem.model.TempBillitems;

@Service
public class TempItemsToBillItesms {
	
	
	
	public Billitems Convert(TempBillitems toConvert,int billID){
		 Billitems converted=new Billitems();
		
		converted.setItemNo(toConvert.getItemNo());
		converted.setPrice(toConvert.getPrice());
		converted.setQty(toConvert.getQty());
		converted.setReduseDiscount(toConvert.getReduseDiscount());
		converted.setAmount(toConvert.getAmount());
		converted.setBillId(billID);
		return converted;
	}
}
