package cn.hl.gof.creation5.simplefactory;

public class PaintingToolFactory {

	public static PaintingTools getTool(String type) throws UnSupportedShapeException {
		PaintingTools tool = null;
		if("circle".equals(type)) {
			tool = new CircleTool();
		}
		else if("square".equals(type)) {
			tool = new SquareTool();
		}
		else if("rectangle".equals(type)) {
			tool = new RectangleTool();
		}else {
			throw new UnSupportedShapeException("不支持此形状:["+type+"]");
		}
		return tool;
	} 
}
