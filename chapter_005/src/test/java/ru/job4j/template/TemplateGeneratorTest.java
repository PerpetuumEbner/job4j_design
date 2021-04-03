package ru.job4j.template;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;

public class TemplateGeneratorTest {

    @Ignore
    @Test
    public void whenTemplateExecuted() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> templateMap = new HashMap();
        templateMap.put("name", "Petr Arsentev");
        templateMap.put("subject ", "you");
        String verifiedTemplate = generator.produce(template, templateMap);
        Assert.assertThat(template, is(verifiedTemplate));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenTemplateContainsKeysThatNotInMap() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> templateMap = new HashMap();
        templateMap.put("name", "Petr Arsentev");
        String verifiedTemplate = generator.produce(template, templateMap);
        Assert.assertThat(template, is(verifiedTemplate));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenExtraKeysInMap() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> templateMap = new HashMap();
        templateMap.put("name", "Petr Arsentev");
        templateMap.put("subject ", "you");
        templateMap.put("key ", "extra");
        String verifiedTemplate = generator.produce(template, templateMap);
        Assert.assertThat(template, is(verifiedTemplate));
    }
}