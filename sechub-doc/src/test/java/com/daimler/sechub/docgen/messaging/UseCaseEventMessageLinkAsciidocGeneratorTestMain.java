package com.daimler.sechub.docgen.messaging;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.daimler.sechub.sharedkernel.messaging.MessageID;
import com.daimler.sechub.sharedkernel.usecases.UseCaseIdentifier;

public class UseCaseEventMessageLinkAsciidocGeneratorTestMain {

    private static final Logger LOG = LoggerFactory.getLogger(UseCaseEventMessageLinkAsciidocGeneratorTestMain.class);

    public static void main(String[] args) throws IOException {
        System.setProperty("com.daimler.sechub.docgen.debug", "true");

        File outputFolder = new File("./build/tmp/gen-asciidoc/");

        Map<UseCaseIdentifier, Set<String>> usecaseToMessageIdMap = new TreeMap<>();
        Set<String> list = new TreeSet<>();
        list.add(MessageID.BATCH_JOB_STATUS.name());
        list.add(MessageID.JOB_DONE.name());
        usecaseToMessageIdMap.put(UseCaseIdentifier.UC_ADMIN_RESTARTS_JOB, list);
        
        list = new TreeSet<>();
        list.add(MessageID.BATCH_JOB_STATUS.name());
        list.add(MessageID.JOB_DONE.name());
        usecaseToMessageIdMap.put(UseCaseIdentifier.UC_ADMIN_RESTARTS_JOB_HARD, list);
        
        UseCaseEventMessageLinkAsciidocGenerator generator = new UseCaseEventMessageLinkAsciidocGenerator(usecaseToMessageIdMap, outputFolder);
        generator.generate();
    }

}
