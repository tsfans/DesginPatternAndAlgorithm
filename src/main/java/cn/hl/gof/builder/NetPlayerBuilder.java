package cn.hl.gof.builder;

public class NetPlayerBuilder extends PlayerBuilder{

	@Override
	public void buildDisplayMenu() {
		player.setDisplayMenu("network displaymenu");
	}

	@Override
	public void buildPlayList() {
		player.setPlayList("network playlist");
	}

	@Override
	public void buildMainWindow() {
		player.setMainWindow("network mainwindow");
	}

	@Override
	public void buildControlBar() {
		player.setControlBar("network controlbar");
	}

	@Override
	public void buildCollectionList() {
		player.setCollectionList("network collectionlist");
	}
	
	@Override
	public void buildNetwork() {
		player.setNetwork("network network");
	}

	@Override
	public String type() {
		return "network";
	}
}
