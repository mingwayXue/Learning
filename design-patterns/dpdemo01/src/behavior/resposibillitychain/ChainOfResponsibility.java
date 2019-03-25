package behavior.resposibillitychain;

/** 设计模式：责任链模式（Chain of Responsibility）
 *
 * 有多个对象，每个对象持有对下一个对象的引用，这样就会形成一条链，请求在这条链上传递，直到某一对象决定处理该请求；
 * 链接上的请求可以是一条链，可以是一个树，还可以是一个环，模式本身不约束这个，需要我们自己去实现，同时，在一个时刻，命令只允许由一个对象传给另一个对象，而不允许传给多个对象；
 * Created by mingway on Date:2018-12-10 17:25.
 * 修改记录
 * 修改后版本:     修改人：  修改日期:     修改内容:
 */
public class ChainOfResponsibility {
	public static void main(String[] args) {
		MyHandler h1 = new MyHandler("h1");
		MyHandler h2 = new MyHandler("h2");
		MyHandler h3 = new MyHandler("h3");

		h1.setHandler(h2);
		h2.setHandler(h3);
		h1.operator();
	}
}

interface Handler {
	void operator();
}

abstract class AbstractHandler {

	private Handler handler;

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}

class MyHandler extends AbstractHandler implements Handler {

	private String name;

	public MyHandler(String name) {
		this.name = name;
	}

	@Override
	public void operator() {
		System.out.println( name + "deal!");
		if(getHandler() != null){
			getHandler().operator();	//责任链模式的关键处理
		}
	}
}