package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import _07_intro_to_mocking.models.Engine;
import _07_intro_to_mocking.models.GasTank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;

    @Mock
    Engine engine;

    @Mock
    GasTank gasTank;
    
    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    	
    	deliveryDriver = new DeliveryDriver("Bob", new Car(engine, gasTank), new CellPhone());
    }

    @Test
    void itShouldWasteTime() {
        //given
    	boolean expectedWasteTime = true;
    	
        //when
    	boolean actualWasteTime = deliveryDriver.wasteTime();
    	
        //then
    	assertEquals(expectedWasteTime, actualWasteTime);
    }

    @Test
    void itShouldRefuel() {
        //given
    	boolean expectedRefuel = true;
    	int octane = 85;
    	
    	when(gasTank.fill(octane)).thenReturn(true);
    	
        //when
    	boolean actualRefuel = deliveryDriver.refuel(octane);
    	
        //then
    	assertEquals(expectedRefuel, actualRefuel);
    }

    @Test
    void itShouldContactCustomer() {
        //given
    	boolean expectedCall = true;
    	
        //when
    	boolean actualCall = deliveryDriver.contactCustomer("1 123 456 7890");
    	
        //then
    	assertEquals(expectedCall, actualCall);
    }

}