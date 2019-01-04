///*
// * Copyright (C) 2007 The Android Open Source Project
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package com.Plugins.MyAllPlugins.hash.util;
///**
// * Provides a limited interface to the Dalvik VM stack. This class is mostly
// * used for implementing security checks.
// *
// * @hide
// */
//public final class VMStack {
//    /**
//     * Returns the defining class loader of the caller's caller.
//     *
//     * @return the requested class loader, or {@code null} if this is the
//     *         bootstrap class loader.
//     */
//    native public static ClassLoader getCallingClassLoader();
//    /**
//     * Returns the class of the caller's caller's caller.
//     *
//     * @return the requested class, or {@code null}.
//     */
//    native public static Class<?> getStackClass2();
//    /**
//     * Creates an array of classes from the methods at the top of the stack.
//     * We continue until we reach the bottom of the stack or exceed the
//     * specified maximum depth.
//     * <p>
//     * The topmost stack frame (this method) and the one above that (the
//     * caller) are excluded from the array.  Frames with java.lang.reflect
//     * classes are skipped over.
//     * <p>
//     * The classes in the array are the defining classes of the methods.
//     * <p>
//     * This is similar to Harmony's VMStack.getClasses, except that this
//     * implementation doesn't have a concept of "privileged" frames.
//     *
//     * @param maxDepth
//     *      maximum number of classes to return, or -1 for all
//     * @return an array with classes for the most-recent methods on the stack
//     */
//    native public static Class<?>[] getClasses(int maxDepth);
//    /**
//     * Returns the first ClassLoader on the call stack that isn't either of
//     * the passed-in ClassLoaders.
//     */
//    public static ClassLoader getClosestUserClassLoader(ClassLoader bootstrap,
//                                                        ClassLoader system) {
//        Class<?>[] stackClasses = VMStack.getClasses(-1);
//        for (Class<?> stackClass : stackClasses) {
//            ClassLoader loader = stackClass.getClassLoader();
//            if (loader != null && loader != bootstrap && loader != system) {
//                return loader;
//            }
//        }
//        return null;
//    }
//    /**
//     * Retrieves the stack trace from the specified thread.
//     *
//     * @param t
//     *      thread of interest
//     * @return an array of stack trace elements, or null if the thread
//     *      doesn't have a stack trace (e.g. because it exited)
//     */
//    native public static StackTraceElement[] getThreadStackTrace(Thread t);
//    /**
//     * Retrieves a partial stack trace from the specified thread into
//     * the provided array.
//     *
//     * @param t
//     *      thread of interest
//     * @param stackTraceElements
//     *      preallocated array for use when only the top of stack is
//     *      desired. Unused elements will be filled with null values.
//     * @return the number of elements filled
//     */
//    native public static int fillStackTraceElements(Thread t,
//                                                    StackTraceElement[] stackTraceElements);
//}