package com.sfeir.labs.client;

import java.util.ArrayList;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class Model {

	private ArrayList<ArrayList<String>> allInfo;
	
	private final Splitter lineSplitter = Splitter.on(";").omitEmptyStrings()
			.trimResults().trimResults(CharMatcher.is('"'));

	public ArrayList<ArrayList<String>> getAllInfo() {
		return allInfo;
	}

	public Splitter getLineSplitter() {
		return lineSplitter;
	}

	public Splitter getFileSplitter() {
		return fileSplitter;
	}

	private final Splitter fileSplitter = Splitter.on("\n");// .omitEmptyStrings();

	public Model(ArrayList<ArrayList<String>> info) {
		this.allInfo = info;
	}

	public String getMoisAn(int month) {
		Iterable<String> entetes = lineSplitter
				.split(allInfo.get(month).get(1));
		String moisAn = Iterables.get(entetes, 1);
		return moisAn;
	}

	public ArrayList<String> getEpicerieTotal() {
		ArrayList<String> result = new ArrayList<String>(allInfo.size());
		for (int i = 0; i < allInfo.size(); i++) {
			result.add(allInfo.get(i).get(4));
		}
		return result;
		// if (infoMois.isEmpty()) {
		// try {
		// getListCategories();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// List<String> result = Lists.newArrayList(lineSplitter.split(infoMois
		// .get(4)));
		// // String[] array = this.allInfo.get(4).split(";+");
		// return result;
	}

	public ArrayList<String> getEpicerieSalee() {
		ArrayList<String> result = new ArrayList<String>(allInfo.size());
		for (int i = 0; i < allInfo.size(); i++) {
			result.add(allInfo.get(i).get(5));
		}
		return result;
	}

	public ArrayList<String> getEpicerieSucree() {
		ArrayList<String> result = new ArrayList<String>(allInfo.size());
		for (int i = 0; i < allInfo.size(); i++) {
			result.add(allInfo.get(i).get(6));
		}
		return result;
	}

	public ArrayList<String> getLiquideTotal() {
		ArrayList<String> result = new ArrayList<String>(allInfo.size());
		for (int i = 0; i < allInfo.size(); i++) {
			result.add(allInfo.get(i).get(7));
		}
		return result;
		// String[] array = this.infoMois.get(7).split(";+");
		// return array;
	}
	//
	// public String[] getLiquideEaux() {
	// String[] array = this.infoMois.get(8).split(";+");
	// return array;
	// }
	//
	// public String[] getLiquideBierre() {
	// String[] array = this.infoMois.get(9).split(";+");
	// return array;
	// }
	//
	// public String[] getLiquideChampagne() {
	// String[] array = this.infoMois.get(10).split(";+");
	// return array;
	// }
	//
	// public String[] getLibreserviceTotal() {
	// String[] array = this.infoMois.get(11).split(";+");
	// return array;
	// }
	//
	// public String[] getLibreserviceGlace() {
	// String[] array = this.infoMois.get(12).split(";+");
	// return array;
	// }
	//
	// public String[] getLibreserviceCremerie() {
	// String[] array = this.infoMois.get(13).split(";+");
	// return array;
	// }
	//
	// public String[] getLibreserviceFrais() {
	// String[] array = this.infoMois.get(14).split(";+");
	// return array;
	// }
	//
	// public String[] getDroguerieTotal() {
	// String[] array = this.infoMois.get(15).split(";+");
	// return array;
	// }
	//
	// public String[] getDroguerieEntretien() {
	// String[] array = this.infoMois.get(16).split(";+");
	// return array;
	// }
	//
	// public String[] getDroguerieHygiene() {
	// String[] array = this.infoMois.get(17).split(";+");
	// return array;
	// }
	//
	// public String[] getEnsemble() {
	// String[] array = this.infoMois.get(18).split(";+");
	// return array;
	// }
	//
	// public List<String> getAllCategories() {
	// List<String> result = new ArrayList<String>();
	// for (String line : infoMois) {
	// result.add(Iterables.get(lineSplitter.split(line), 0, "")
	// .replaceAll("dont", ""));
	// }
	// return result;
	// }

}
