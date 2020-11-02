package com.kiddz.elysium.core.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
 *
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 *
 *
 *
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 *
 * Example 2:
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 *
 * Example 3:
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 *
 * Example 4:
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 *
 * Example 5:
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 *
 * Example 6:
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */
public class SimplifyPath {

    public static void main(String[] args) {
        String path1 = "/home/";
        System.out.println(simplifyPath(path1));
        String path2 = "/../";
        System.out.println(simplifyPath(path2));
        String path3 = "/home//foo/";
        System.out.println(simplifyPath(path3));
        String path4 = "/a/./b/../../c/";
        System.out.println(simplifyPath(path4));
        String path5 = "/a/../../b/../c//.//";
        System.out.println(simplifyPath(path5));
        String path6 = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path6));
    }

    private static String simplifyPath(String path) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] paths = path.split("/");
        for (String s : paths) {
            if ("..".equals(s)) {
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            } else if (!"".equals(s) && !".".equals(s)) {
                queue.addLast(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (String str : queue) {
            sb.append(str);
            sb.append("/");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
