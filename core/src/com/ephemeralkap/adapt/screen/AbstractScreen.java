/* CLASS:
 * AUTHOR: EphemeralKap
 * DESCRIPTION:
 ****************************************************************************/
package com.ephemeralkap.adapt.screen;

import com.ephemeralkap.adapt.BetterAdapt;

public abstract class AbstractScreen {
    protected BetterAdapt game;
    
    public AbstractScreen(BetterAdapt game) {
        this.game = game;
    }
    
    public abstract void update(float delta);
    
    public abstract void dispose();
    
} 