package fr.loferga.model.world.configuration;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

public class CustomRepresenter extends Representer {
	
	public static final CustomRepresenter DEFAULT_REPRESENTER = new CustomRepresenter();
	
	private static final DumperOptions DEFAULT_DUMPER_OPTIONS = new DumperOptions();
	
	public CustomRepresenter() {
		super(DEFAULT_DUMPER_OPTIONS);
	}

	public CustomRepresenter(DumperOptions dumpOptions) {
		super(dumpOptions);
	}
	
	@Override
    protected NodeTuple representJavaBeanProperty(Object javaBean, Property property, Object propertyValue, Tag customTag) {
        if (propertyValue == null) {
            return null; // Exclude null-valued properties
        }
        return super.representJavaBeanProperty(javaBean, property, propertyValue, customTag);
    }
	
}