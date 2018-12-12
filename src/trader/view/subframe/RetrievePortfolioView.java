package trader.view.subframe;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import trader.view.FieldName;
import trader.view.GuiView;

/**
 * RetrievePortfolioView Class.
 */
public class RetrievePortfolioView extends JFrame implements GuiView {
  private JButton submit;
  private JButton back;
  private JButton hint;
  private final String[] fieldLabel = {FieldName.PORTFOLIO_NAME_RETRIEVE.getMsg()};
  private final Form form = new Form(fieldLabel);

  /**
   * Constructor for RetrievePortfolioView.
   *
   * @param caption caption.
   */
  public RetrievePortfolioView(String caption) {
    super(caption);
    this.setLocation(400, 200);
    this.setPreferredSize(new Dimension(600, 300));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().add(form, BorderLayout.NORTH);

    submit = new JButton(FieldName.SUBMIT.getMsg());
    submit.setActionCommand(FieldName.RETRIEVE_PORTFOLIO_SUBMIT.getMsg());
    back = new JButton(FieldName.BACK.getMsg());
    back.setActionCommand(FieldName.RETRIEVE_PORTFOLIO_BACK.getMsg());
    hint = new JButton(FieldName.CHECK_CURRENT_PORTFOLIO_ENTER.getMsg());
    hint.setActionCommand(FieldName.CHECK_CURRENT_PORTFOLIO_ENTER.getMsg());

    JPanel mainPanel = new JPanel();
    mainPanel.add(submit);
    mainPanel.add(back);
    mainPanel.add(hint);
    this.getContentPane().add(mainPanel, BorderLayout.SOUTH);
    this.pack();
    this.setVisible(true);
  }

  /**
   * Get the string from the text field and return it.
   *
   * @return the user input
   */
  @Override
  public String getInputString() {
    StringBuilder sb = new StringBuilder();
    for (JTextField text : form.getField()) {
      sb.append("\n");
      sb.append(text.getText());
    }
    return sb.toString().substring(1);
  }

  /**
   * This is to force the view to have a method to set up actions for buttons. All the buttons must
   * be given this action listener. Thus our Swing-based implementation of this interface will
   * already have such a method.
   *
   * @param listener the ActionListener
   */
  @Override
  public void addActionListener(ActionListener listener) {
    submit.addActionListener(listener);
    hint.addActionListener(listener);
    back.addActionListener(listener);
  }
}