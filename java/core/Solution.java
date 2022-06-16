package core;

import java.net.URL;

/**
 * All solutions should obey this interface.
 * */
public interface Solution {
    /**
     * To describe the main idea of this solution
     * */
    String describe();
    /**
     * Get the source URL of leetcode problem.
     * */
    URL link();
}
