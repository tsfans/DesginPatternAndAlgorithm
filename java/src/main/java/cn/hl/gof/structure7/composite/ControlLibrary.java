package cn.hl.gof.structure7.composite;

/**
 * 组合模式实现抽象控件库
 * @author HULIN
 * @date 2018年3月2日下午4:10:08
 */
public abstract class ControlLibrary {

	protected abstract void add(ControlLibrary controlLibrary);
	
	protected abstract void remove(ControlLibrary controlLibrary);
	
	protected abstract ControlLibrary getControl(int index);
	
	protected abstract void draw();
}
