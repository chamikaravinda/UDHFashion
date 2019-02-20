package com.UDHFashion.udhmanagmentsystem.service;

import java.util.List;

import com.UDHFashion.udhmanagmentsystem.model.Barcode;

public interface IBarcodeDAO {
	
	public abstract void insertBarcodeDetails( Barcode barcode );
	public abstract List<Barcode> getAllBarcodeDetails();
	public abstract void deleteBarcodeData( String itemCode );
	public abstract boolean isBarcordRecorded( String itemCode );
	
}
