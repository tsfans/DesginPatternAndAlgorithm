package cn.hl.gof.creation5.builder;

public class ConcisePlayerBuilder extends PlayerBuilder{

	@Override
	public void buildDisplayMenu() {
		player.setDisplayMenu("concise displaymenu");
	}

	@Override
	public void buildPlayList() {
		player.setPlayList("concise playlist");
	}

	@Override
	public void buildMainWindow() {
		player.setMainWindow("concise mainwindow");
	}

	@Override
	public void buildControlBar() {
		player.setControlBar("concise controlbar");
	}

	@Override
	public void buildCollectionList() {
		player.setCollectionList("concise collectionlist");
	}
	
	@Override
	public void buildNetwork() {
		player.setNetwork("concise network");
	}

	@Override
	public String type() {
		return "concise";
	}

}
