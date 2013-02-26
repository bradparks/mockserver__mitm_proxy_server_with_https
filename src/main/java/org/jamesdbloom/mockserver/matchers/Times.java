package org.jamesdbloom.mockserver.matchers;

import org.jamesdbloom.mockserver.model.ModelObject;

/**
 * @author jamesdbloom
 */
public class Times extends ModelObject {

    private int remainingTimes;
    private boolean unlimited;

    private Times(int remainingTimes, boolean unlimited) {
        this.remainingTimes = remainingTimes;
        this.unlimited = unlimited;
    }

    public static Times unlimited() {
        return new Times(1, true);
    }

    public static Times once() {
        return new Times(1, false);
    }

    public static Times exactly(int count) {
        return new Times(count, false);
    }

    public boolean greaterThenZero() {
        return unlimited || remainingTimes > 0;
    }

    public void decrement() {
        if (!unlimited) {
            remainingTimes--;
        }
    }

    public void setNotUnlimitedResponses() {
        unlimited = false;
    }
}