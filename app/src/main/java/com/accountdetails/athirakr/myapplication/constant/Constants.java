package com.accountdetails.athirakr.myapplication.constant;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class Constants {
    public static final String jsonData="{\n" +
            "\t\"data\": {\n" +
            "\t\t\"type\": \"accounts\",\n" +
            "\t\t\"id\": \"2593177\",\n" +
            "\t\t\"attributes\": {\n" +
            "\t\t\t\"payment-type\": \"prepaid\",\n" +
            "\t\t\t\"unbilled-charges\": null,\n" +
            "\t\t\t\"next-billing-date\": null,\n" +
            "\t\t\t\"title\": \"Ms\",\n" +
            "\t\t\t\"first-name\": \"Joe\",\n" +
            "\t\t\t\"last-name\": \"Bloggs\",\n" +
            "\t\t\t\"date-of-birth\": \"1985-01-01\",\n" +
            "\t\t\t\"contact-number\": \"0404000000\",\n" +
            "\t\t\t\"email-address\": \"test@mivi.com\",\n" +
            "\t\t\t\"email-address-verified\": false,\n" +
            "\t\t\t\"email-subscription-status\": false\n" +
            "\t\t},\n" +
            "\t\t\"links\": {\n" +
            "\t\t\t\"self\": \"http://localhost:3000/accounts/2593177\"\n" +
            "\t\t},\n" +
            "\t\t\"relationships\": {\n" +
            "\t\t\t\"services\": {\n" +
            "\t\t\t\t\"links\": {\n" +
            "\t\t\t\t\t\"related\": \"http://localhost:3000/services/0468874507\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t\"included\": [{\n" +
            "\t\t\t\"type\": \"services\",\n" +
            "\t\t\t\"id\": \"0468874507\",\n" +
            "\t\t\t\"attributes\": {\n" +
            "\t\t\t\t\"msn\": \"0468874507\",\n" +
            "\t\t\t\t\"credit\": 1200,\n" +
            "\t\t\t\t\"credit-expiry\": \"2016-11-20\",\n" +
            "\t\t\t\t\"data-usage-threshold\": false\n" +
            "\t\t\t},\n" +
            "\t\t\t\"links\": {\n" +
            "\t\t\t\t\"self\": \"http://localhost:3000/services/0468874507\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"relationships\": {\n" +
            "\t\t\t\t\"subscriptions\": {\n" +
            "\t\t\t\t\t\"links\": {\n" +
            "\t\t\t\t\t\t\"related\": \"http://localhost:3000/services/0468874507/subscriptions\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"data\": [{\n" +
            "\t\t\t\t\t\t\"type\": \"subscriptions\",\n" +
            "\t\t\t\t\t\t\"id\": \"0468874507-0\"\n" +
            "\t\t\t\t\t}]\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"type\": \"subscriptions\",\n" +
            "\t\t\t\"id\": \"0468874507-0\",\n" +
            "\t\t\t\"attributes\": {\n" +
            "\t\t\t\t\"included-data-balance\": 52400,\n" +
            "\t\t\t\t\"included-credit-balance\": null,\n" +
            "\t\t\t\t\"included-rollover-credit-balance\": null,\n" +
            "\t\t\t\t\"included-rollover-data-balance\": null,\n" +
            "\t\t\t\t\"included-international-talk-balance\": null,\n" +
            "\t\t\t\t\"expiry-date\": \"2016-11-19\",\n" +
            "\t\t\t\t\"auto-renewal\": true,\n" +
            "\t\t\t\t\"primary-subscription\": true\n" +
            "\t\t\t},\n" +
            "\t\t\t\"links\": {\n" +
            "\t\t\t\t\"self\": \"http://localhost:3000/services/0468874507/subscriptions/0468874507-0\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"relationships\": {\n" +
            "\t\t\t\t\"service\": {\n" +
            "\t\t\t\t\t\"links\": {\n" +
            "\t\t\t\t\t\t\"related\": \"http://localhost:3000/services/0468874507\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"product\": {\n" +
            "\t\t\t\t\t\"data\": {\n" +
            "\t\t\t\t\t\t\"type\": \"products\",\n" +
            "\t\t\t\t\t\t\"id\": \"0\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"downgrade\": {\n" +
            "\t\t\t\t\t\"data\": null\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"type\": \"products\",\n" +
            "\t\t\t\"id\": \"4000\",\n" +
            "\t\t\t\"attributes\": {\n" +
            "\t\t\t\t\"name\": \"UNLIMITED 7GB\",\n" +
            "\t\t\t\t\"included-data\": null,\n" +
            "\t\t\t\t\"included-credit\": null,\n" +
            "\t\t\t\t\"included-international-talk\": null,\n" +
            "\t\t\t\t\"unlimited-text\": true,\n" +
            "\t\t\t\t\"unlimited-talk\": true,\n" +
            "\t\t\t\t\"unlimited-international-text\": false,\n" +
            "\t\t\t\t\"unlimited-international-talk\": false,\n" +
            "\t\t\t\t\"price\": 3990\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}\n";
}
