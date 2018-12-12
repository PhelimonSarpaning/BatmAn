package trader.controller.commands;

import trader.ErrorMsg;
import trader.controller.Interactivity;
import trader.model.IRetrievableStrategyTraderModel;

/**
 * This class represent save strategy command.
 */
public class SaveStrategy implements CommandInterface {
  private final String strategyName;

  /**
   * Constructor for SaveStrategy.
   * @param strategyName strategyName.
   */
  public SaveStrategy(String strategyName) {
    this.strategyName = strategyName;
  }

  /**
   * PLay the function with model.
   *
   * @param m model to be played.
   */
  @Override
  public void execute(IRetrievableStrategyTraderModel m) {
    try {
      m.saveStrategy(strategyName);
      System.out.println(Interactivity.SAVE_SUCCESS.getMsg());
    }
    catch (Exception e) {
      if (e instanceof IllegalArgumentException) {
        System.out.println(e.getMessage());
      }
      System.out.println(ErrorMsg.CONTROLLER_SAVE_STRATEGY.getMsg());
    }
  }
}