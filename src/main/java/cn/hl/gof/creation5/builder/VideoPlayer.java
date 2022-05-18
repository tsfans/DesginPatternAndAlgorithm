package cn.hl.gof.creation5.builder;

public class VideoPlayer {

	private String displayMenu;
	
	private String playList;
	
	private String mainWindow;
	
	private String controlBar;
	
	private String collectionList;
	
	private String network;

	@Override
	public String toString() {
		return "VideoPlayer [displayMenu=" + displayMenu + ", playList=" + playList + ", mainWindow=" + mainWindow
				+ ", controlBar=" + controlBar +",collectionList="+collectionList+ ", network=" + network + "]";
	}

	public String getDisplayMenu() {
		return displayMenu;
	}

	public void setDisplayMenu(String displayMenu) {
		this.displayMenu = displayMenu;
	}

	public String getPlayList() {
		return playList;
	}

	public void setPlayList(String playList) {
		this.playList = playList;
	}

	public String getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(String mainWindow) {
		this.mainWindow = mainWindow;
	}

	public String getControlBar() {
		return controlBar;
	}

	public void setControlBar(String controlBar) {
		this.controlBar = controlBar;
	}

	public String getCollectionList() {
		return collectionList;
	}

	public void setCollectionList(String collectionList) {
		this.collectionList = collectionList;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
	
}
