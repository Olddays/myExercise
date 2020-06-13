package com.liu.LeetCode.ThirtyDays202005.exercise;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/6/1.
 */
public class TD29_CourseSchedule {
    public static class Course {
        int no;
        boolean searched;
        List<Course> nextList;

        public Course(int no) {
            this.no = no;
            searched = false;
            nextList = new ArrayList<>();
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        for (int[] target : prerequisites) {
            Course course = courses[target[0]];
            course.nextList.add(courses[target[1]]);
        }
        for (Course course : courses) {
            if (course.searched) {
                continue;
            }
            boolean hasCycle = bfsCycleDiscover(course);
            if (hasCycle) {
                return false;
            }
        }
        return true;
    }

    private static boolean bfsCycleDiscover(Course course) {
        for (Course nextCourse : course.nextList) {
            if (nextCourse.searched) {
                return true;
            }
            nextCourse.searched = true;
            boolean hasSearched = bfsCycleDiscover(nextCourse);
            if (hasSearched) {
                return true;
            }
            nextCourse.searched = false;
        }
        return false;
    }
}
