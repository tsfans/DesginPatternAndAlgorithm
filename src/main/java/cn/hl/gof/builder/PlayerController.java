package cn.hl.gof.builder;

public class PlayerController {

	public VideoPlayer construct(PlayerBuilder pb) {
		switch(pb.type()) {
		case "complete":
			pb.buildDisplayMenu();
			pb.buildPlayList();
			pb.buildMainWindow();
			pb.buildControlBar();
			pb.buildCollectionList();
			pb.buildNetwork();
			break;
		case "concise":
			pb.buildDisplayMenu();
			pb.buildPlayList();
			pb.buildMainWindow();
			pb.buildControlBar();
			break;
		case "memory":
			pb.buildDisplayMenu();
			pb.buildPlayList();
			pb.buildMainWindow();
			pb.buildControlBar();
			pb.buildCollectionList();
			break;
		case "network":
			pb.buildDisplayMenu();
			pb.buildPlayList();
			pb.buildMainWindow();
			pb.buildControlBar();
			pb.buildNetwork();
			break;
		default:
			System.out.println("contruct failure!");
		}
		VideoPlayer player = pb.createPlayer();
		return player;
	}
}
