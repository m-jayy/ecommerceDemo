package com.example.ecommercedemo.Helpers;

import androidx.annotation.AnimRes;
import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ecommercedemo.Interface.ICallOnResume;
import com.example.ecommercedemo.UI.Fragments.Base;

public class FragmentHandler {
    private static final String TAG = FragmentHandler.class.getSimpleName();
    FragmentManager fragmentManager;
    @IdRes
    int containerId;


    ICallOnResume _ICallOnResume;
    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public FragmentHandler(@IdRes int containerId, FragmentActivity context) {
        this.containerId = containerId;
        fragmentManager = context.getSupportFragmentManager();

    }

    public FragmentHandler(@IdRes int containerId, FragmentActivity context, ICallOnResume _iCallOnResume ) {
        this.containerId = containerId;
        fragmentManager = context.getSupportFragmentManager();
        _ICallOnResume = _iCallOnResume;


    }

    public FragmentHandler(@IdRes int containerId, FragmentManager fragmentManager) {
        this.containerId = containerId;
        this.fragmentManager = fragmentManager;
    }

    /*pops the open frament*/
    public void popStack() {
        fragmentManager.popBackStack();
    }

    /*replacing fragment transcation region starts*/
    public void replaceFragment(Base fragment,
                                boolean addToBackStack) {
        addReplaceFragment(fragment, addToBackStack, false, true);
    }

    public void replaceFragment(Base fragment,
                                boolean addToBackStack,
                                boolean clearBackStack) {
        addReplaceFragment(fragment, addToBackStack, clearBackStack, true);
    }

    public void addReplaceFragment(Base fragment,
                                   boolean addToBackStack,
                                   boolean clearBackStack,
                                   boolean replaceFragment) {
        try {
            if (clearBackStack && fragmentManager.getBackStackEntryCount() > 0) {
                FragmentManager.BackStackEntry first = fragmentManager.getBackStackEntryAt(0);
                fragmentManager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (replaceFragment) {
                fragmentTransaction.replace(containerId, fragment, fragment.getClass().getName());
            } else {
                fragmentTransaction.add(containerId, fragment, fragment.getClass().getName());
            }
            if (addToBackStack) {
                fragmentTransaction.addToBackStack(fragment.getClass().getName());
            }
            fragmentTransaction.commit();


            try {
                if (_ICallOnResume != null) {
                    _ICallOnResume.callOnResume();
                }
            }catch (Exception e)
            {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addReplaceFragmentWithAnimation(Base fragment,
                                                boolean addToBackStack,
                                                boolean replaceFragment,
                                                @AnimRes int enter,
                                                @AnimRes int exit,
                                                @AnimRes int popEnter,
                                                @AnimRes int popExit) {



        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(enter, exit, popEnter, popExit);
        if (replaceFragment) {
            fragmentTransaction.replace(containerId, fragment, fragment.getClass().getName());
        } else {
            fragmentTransaction.add(containerId, fragment, fragment.getClass().getName());
        }
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();

        try {
            if (_ICallOnResume != null) {
                _ICallOnResume.callOnResume();
            }
        }catch (Exception e)
        {

        }
    }

    public void addReplaceFragmentWithAnimation(Base fragment,
                                                boolean addToBackStack,
                                                boolean replaceFragment,
                                                boolean clearBackStack,
                                                @AnimRes int enter,
                                                @AnimRes int exit,
                                                @AnimRes int popEnter,
                                                @AnimRes int popExit) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(enter, exit, popEnter, popExit);

        if (clearBackStack && fragmentManager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = fragmentManager.getBackStackEntryAt(0);
            fragmentManager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        if (replaceFragment) {
            fragmentTransaction.replace(containerId, fragment, fragment.getClass().getName());
        } else {
            fragmentTransaction.add(containerId, fragment, fragment.getClass().getName());
        }
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }


    public void addFragmentWithAnimation(Base fragment,
                                         boolean addToBackStack,
                                         @AnimRes int enter,
                                         @AnimRes int exit) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(enter, exit);
        fragmentTransaction.add(containerId, fragment, fragment.getClass().getName());
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }
    /*Transcation region ends here*/

    /*return count of open fragments*/
    public int getBackStackEntryCount() {
        return fragmentManager.getBackStackEntryCount();
    }

    /*return the last open fragment name*/
    public String getTopFragmentName() {
        return fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();

    }

    /*returns the last open Fragment*/
    public Fragment getTopFragment() {
        return fragmentManager.getFragments().get(fragmentManager.getFragments().size() - 1);
    }

    /*returns the second last open fragmetn*/
    public Fragment getSecondLastFragment() {
        return fragmentManager.getFragments().get(fragmentManager.getFragments().size() - 2);
    }
}

