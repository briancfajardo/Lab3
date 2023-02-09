package edu.eci.cvds.tdd.registry;
import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test

    public void validateRegistryResult() {
        Person person = new Person("Alfonso", 1000, 30, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    
    @Test
    public void validateIsDead( ){
        Person person = new Person("Andrea", 1007, 20, Gender.FEMALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void validateIsUnderage( ){
        Person person = new Person("Camilin", 1001, 15, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateIsInvalidAge( ){
        Person person = new Person("Jaider", 1003, -15, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validateIsValid( ){
        Person person = new Person("Miguel", 1004, 35, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateIsDuplucated( ){
        Person person = new Person("Angie", 1005, 35, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);

        Person person2 = new Person("Angie", 1005, 35, Gender.MALE, true);
        RegisterResult result2 = registry.registerVoter(person2);

        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }
}