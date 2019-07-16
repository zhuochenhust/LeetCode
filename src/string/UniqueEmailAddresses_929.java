package string;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class UniqueEmailAddresses_929 {
	public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();
        
        for(String email : emails) {
            
            int index = email.indexOf('@');
            String local = email.substring(0, index); 
            String domain = email.substring(index);
            
            if(local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            
            if(local.contains(".")) {
                local = local.replace(".", "");
            }
                        
            result.add(local+domain);
        }
        
        return result.size();
    }
	
	@Test
	public void test() {
		String[] emails = {"test.emailalex@leetcode.com","test.e.mailbob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		int res = numUniqueEmails(emails);
		System.out.println(res);
	}
}
