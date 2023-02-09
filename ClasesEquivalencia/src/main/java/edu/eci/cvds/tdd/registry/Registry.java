package edu.eci.cvds.tdd.registry;

import java.util.HashMap;

public class Registry {

    private HashMap<Integer, Person> registers;

    public Registry (){
        registers = new HashMap<Integer, Person>();
        
    }

    public RegisterResult registerVoter(Person p) {
        RegisterResult result = RegisterResult.VALID;

        if ( !p.isAlive() ){
            
            result = RegisterResult.DEAD;
        }
        else if (p.getAge() < 1){
            result = RegisterResult.INVALID_AGE;
        }
        else if (p.getAge() < 18){
            result = RegisterResult.UNDERAGE;
        }
        else if (registers.containsKey(p.getId())){
            result = RegisterResult.DUPLICATED;
        }
        else{
            registers.put(p.getId(), p);
        }
        return result;
    }
}