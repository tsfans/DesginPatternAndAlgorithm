package cn.hl.gof.builder;

public abstract class PlayerBuilder {
	
	protected VideoPlayer player = new VideoPlayer();
	
	public abstract void buildDisplayMenu();
	
	public abstract void buildPlayList();
	
	public abstract void buildMainWindow();
	
	public abstract void buildControlBar();
	
	public abstract void buildCollectionList();
	
	public abstract void buildNetwork();
	
	public abstract String type();
	
	public VideoPlayer createPlayer() {
		return player;
	}
}
