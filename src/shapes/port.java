package shapes;
import java.awt.Dimension;
import java.awt.Point;

public class port {
	public Point point;
	public int port_type;
	private int w_h_of_port = 12;

	public port(Point port_point, int port_type) {
		this.point = port_point;
		this.port_type = port_type;
	}
	public int port_type() {
		return this.port_type;
	}
}