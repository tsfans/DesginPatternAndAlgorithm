package cn.hl.gof.creation5.builder;

public class CompletePlayerBuilder extends PlayerBuilder{

	@Override
	public void buildDisplayMenu() {
		player.setDisplayMenu("complete displaymenu");
	}

	@Override
	public void buildPlayList() {
		player.setPlayList("complete playlist");
	}

	@Override
	public void buildMainWindow() {
		player.setMainWindow("complete mainwindow");
	}

	@Override
	public void buildControlBar() {
		player.setControlBar("complete controlbar");
	}

	@Override
	public void buildCollectionList() {
		player.setCollectionList("complete collectionlist");
	}
	
	@Override
	public void buildNetwork() {
		player.setNetwork("complete network");
	}

	@Override
	public String type() {
		return "complete";
	}


}
