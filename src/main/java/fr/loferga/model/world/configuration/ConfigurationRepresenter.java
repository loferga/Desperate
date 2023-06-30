package fr.loferga.model.world.configuration;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

public class ConfigurationRepresenter extends Representer {
	
	private static final DumperOptions DEFAULT_DUMPER_OPTIONS = createDefaultDumperOptions();
	private static DumperOptions createDefaultDumperOptions() {
		DumperOptions toReturn = new DumperOptions();
		toReturn.setIndent(3);
		toReturn.setIndentWithIndicator(true);
		toReturn.setExplicitStart(false);
		toReturn.setExplicitEnd(false);
		return toReturn;
	}
	
	public static final ConfigurationRepresenter DEFAULT_REPRESENTER = new ConfigurationRepresenter(DEFAULT_DUMPER_OPTIONS);

	public ConfigurationRepresenter(DumperOptions dumpOptions) {
		super(dumpOptions);
		super.addClassTag(Configuration.class, Tag.MAP);
	}
	
	@Override
    protected NodeTuple representJavaBeanProperty(Object javaBean, Property property, Object propertyValue, Tag customTag) {
        if (propertyValue == null) {
            return null; // Exclude null-valued properties
        }
        return super.representJavaBeanProperty(javaBean, property, propertyValue, customTag);
    }
	
}