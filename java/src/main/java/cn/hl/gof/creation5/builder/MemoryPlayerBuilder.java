package cn.hl.gof.creation5.builder;

public class MemoryPlayerBuilder extends PlayerBuilder{

	@Override
	public void buildDisplayMenu() {
		player.setDisplayMenu("memory displaymenu");
	}

	@Override
	public void buildPlayList() {
		player.setPlayList("memory playlist");
	}

	@Override
	public void buildMainWindow() {
		player.setMainWindow("memory mainwindow");
	}

	@Override
	public void buildControlBar() {
		player.setControlBar("memory controlbar");
	}

	@Override
	public void buildCollectionList() {
		player.setCollectionList("memory collectionlist");
	}
	
	@Override
	public void buildNetwork() {
		player.setNetwork("memory network");
	}

	@Override
	public String type() {
		return "memory";
	}
}
