package com.sfeir.labs.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("data")
public interface DataRPC extends RemoteService {

	ArrayList<ArrayList<String>> getListCategories() throws  Exception;
	
	public String getMoisAn();

	public StatsCategorie getStatsCategorie(String nom) ;
	
	public List<String> getEpicerieTotal();

	public String[] getEpicerieSalee();

	public String[] getEpicerieSucree();

	public String[] getLiquideTotal();
	
	public String[] getLiquideEaux();

	public String[] getLiquideBierre();

	public String[] getLiquideChampagne();

	public String[] getLibreserviceTotal();

	public String[] getLibreserviceGlace();

	public String[] getLibreserviceCremerie();

	public String[] getLibreserviceFrais();

	public String[] getDroguerieTotal();

	public String[] getDroguerieEntretien();

	public String[] getDroguerieHygiene();

	public String[] getEnsemble();
	
public List<String> getAllCategories();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
