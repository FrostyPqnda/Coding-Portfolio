import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class GrandmaBtn controls the timer and score counter of the Grandma
 * upgrade
 * 
 * @author Brian P. 
 * @version 18 March 2020
 */
public class GrandmaBtn extends Button
{
    public int grannyPrice = 25; // Starting price of granny upgrade
    private int GN = 0;
    private int gCounter = 0;
    /**
     * Act - do whatever the GrandmaBtn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getWorld().isPaused == false && getWorld().startPressed == true)
        {
            setLocation(50, 48);
            checkBuy();
            getWorld().showText("" + grannyPrice, 105, 48);
        }
    }
    /**
     * Method checkBuy subtracts from points after purchase
     */
    public void checkBuy()
    {
        Score grannyCost = getWorld().getScore();
        if(grannyCost.getPoint() >= grannyPrice)
        {
            if(Greenfoot.mouseClicked(this))
            {
                buyGranny();
                Greenfoot.playSound("buy4.wav");
                grannyCost.subtractPoint(grannyPrice);
                GN++;
                updateGrannyCounter();
                futureValue();
                getWorld().antiCheatScore();
            }
        }
    }
    /**
     * Method futureValue will change value after purchase
     */
    public void futureValue()
    {
        grannyPrice = grannyPrice + ((3^(GN+1))*GN) + (1+(3^GN)*(GN));
    }
    /**
     * Method updateGrannyCounter keeps track of upgrades bought
     */
    public void updateGrannyCounter()
    {       
        Score point = getWorld().getGrandmaCounter();
        point.addPoint(1);
        gCounter++;
    }
    public int getGUpgrade()
    {
        return gCounter;
    }
    /**
     * Method getWorld returns the actor's world as a BrownieWorld
     */
    public BrownieWorld getWorld()
    {
        return (BrownieWorld)(super.getWorld());
    }
}
