package org.velezreyes.quiz.question6;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineImpl implements VendingMachine{

  private static VendingMachine instance;
  private int quarters = 0;

  static List<Drink> drinks = new ArrayList<Drink>();


    /**
     * Returns the instance of the VendingMachine with the list of drinks initialized with ScottCola and KarenTea
     * @return VendingMachine
     */

  public static VendingMachine getInstance() {
    drinks = List.of(new DrinkImpl("ScottCola", true, 3), new DrinkImpl("KarenTea", false, 4));
    if(instance == null) {
      instance = new VendingMachineImpl();
    }
    return instance;
  }

    /**
     * Inserts a quarter into the vending machine
     */
  @Override
  public void insertQuarter() {
    quarters++;
  }

    /**
     * Charges the balance of the vending machine
     * @param amount
     */
  public void chargeBalance(int amount) {
    quarters -= amount;
  }

    /**
     * Presses a button to get a drink
     * @param name
     * @return Drink
     * @throws NotEnoughMoneyException
     * @throws UnknownDrinkException
     */
  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    Drink drink = getDrink(name);
    validateBalance(drink.getPrice());
    return drink;
  }


  /**
   * Gets a drink from the list of drinks and throws an exception if it doesn't exist
   * @param name
   * @return Drink
   * @throws UnknownDrinkException
   */
  private Drink getDrink(String name) throws UnknownDrinkException {
    return drinks.stream().filter(d -> d.getName().equals(name)).findFirst().orElseThrow(UnknownDrinkException::new);
  }

  /**
   * Validates the balance of the vending machine and throws an exception if there is not enough money
   * @param drinkPrice
   * @throws NotEnoughMoneyException
   */
  private void validateBalance(int drinkPrice) throws NotEnoughMoneyException {
    if(drinkPrice > quarters) {
      throw new NotEnoughMoneyException();
    }
    chargeBalance(drinkPrice);
  }
}
