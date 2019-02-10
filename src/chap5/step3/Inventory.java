package chap5.step3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import chap5.step1.Guitar;
import chap5.step1.GuitarSpec;
import chap5.step1.Instrument;
import chap5.step1.InstrumentSpec;
import chap5.step1.Mandolin;
import chap5.step1.MandolinSpec;

//Now, the encapsulated specs are only used for searching

public class Inventory {

	private List instruments;

	public Inventory() {
		instruments = new LinkedList<>();
	}
	
	
	//still an  issue

	public void addInstrument(int serialNumber, double price, InstrumentSpec instrumentSpec) {
		Instrument instrument = null;
		if (instrumentSpec instanceof GuitarSpec) {
			instrument = new Guitar(serialNumber, price, (GuitarSpec) instrumentSpec);
		} else if (instrumentSpec instanceof MandolinSpec) {
			instrument = new Mandolin(serialNumber, price, (MandolinSpec) instrumentSpec);
		}
		instruments.add(instrument);
	}

	// will return all instruments
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List search(InstrumentSpec searchInstrumentSpec) {
		// Ignore price and name as unique
		List list = new ArrayList<>();
		for (Iterator itr = instruments.iterator(); itr.hasNext();) {

			Instrument i = (Instrument) itr.next();
			if (i.getInstrumentSpec().matches(searchInstrumentSpec)) {
				list.add(i);
			}
		}
		return list;
	}

}
