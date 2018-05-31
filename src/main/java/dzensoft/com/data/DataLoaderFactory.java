package dzensoft.com.data;

public class DataLoaderFactory {

	public static DataLoader create(String type) {
		DataLoader dataLoader = null;
		switch (type) {
		case "csvloader":
			dataLoader = new CsvDataLoader();
			break;
		case "xmlloader":
			dataLoader = new XmlDataLoader();
			break;
		default:
			throw new IllegalArgumentException("There is no valid type to return dataloader!");
		}
		return dataLoader;
	}
}
