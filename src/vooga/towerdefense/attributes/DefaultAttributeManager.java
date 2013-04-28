package vooga.towerdefense.attributes;

import vooga.towerdefense.factories.definitions.ProjectileDefinition;
import vooga.towerdefense.factories.examplesfactories.ExampleDosProjectileFactory;

/**
 * Predefined attributeManager, used for testing purposes only.
 * 
 *
 */
public class DefaultAttributeManager extends AttributeManager {
	
	public DefaultAttributeManager(){
        this.addAttribute(new Attribute(AttributeConstantsEnum.ATTACK_RADIUS.getStatusCode(), 300.0));
        this.addAttribute(new Attribute(AttributeConstantsEnum.DIRECTION.getStatusCode(), 50.0));
        this.addAttribute(new Attribute(AttributeConstantsEnum.ATTACK_INTERVAL.getStatusCode(), 30.0));
        this.addAttribute(new Attribute(AttributeConstantsEnum.NUM_OF_TARGETS.getStatusCode(), 1.0));
        this.addAttribute(new Attribute(AttributeConstantsEnum.ATTACK_RADIUS.getStatusCode(), 200.0));
        this.addAttribute(new Attribute(AttributeConstantsEnum.MOVE_SPEED.getStatusCode(), 1.0));
        this.addAttribute(new Attribute(AttributeConstantsEnum.AURA_EFFECT.getStatusCode(), -10.0));
        this.addAttribute(new Attribute(AttributeConstantsEnum.HEALTH.getStatusCode(), 100.0));

        this.addGameElementFactory(AttributeConstantsEnum.PROJECTILE_FACTORY.getStatusCode(),(new ExampleDosProjectileFactory("projectilefactory", new ProjectileDefinition())));
	}
	

}
