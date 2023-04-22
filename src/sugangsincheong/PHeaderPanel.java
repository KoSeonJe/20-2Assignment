package sugangsincheong;

import javax.swing.JLabel;
import javax.swing.JPanel;

import valueObject.VUser;

public class PHeaderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
    private JLabel welcomelabel;
	public PHeaderPanel() {
		this.welcomelabel = new JLabel();
		this.add(this.welcomelabel);
	}
	public void intialize(VUser vUser) {

		this.welcomelabel.setText(vUser.getName() + "님 환영합니다.");
	}
}
