package br.inatel.dm112.service;

import org.springframework.stereotype.Service;

import br.inatel.dm112.adapter.MailAdapter;
import br.inatel.dm112.model.MailRequestData;
import br.inatel.dm112.model.MailStatusResponse;

@Service
public class MailService {

	public MailStatusResponse sendMail(MailRequestData mailData) {
		if (mailData.getFrom() == null || 
				mailData.getPassword() == null || 
				mailData.getTo() == null) {
			return new MailStatusResponse(MailStatusResponse.STATUS.ERROR.ordinal(), 
					mailData.getFrom(), mailData.getTo());
		}

		MailAdapter sender = new MailAdapter();
		try {
			sender.sendMail(mailData.getFrom(), mailData.getPassword(), mailData.getTo());
		} catch(Exception e) {
			e.printStackTrace();
			return new MailStatusResponse(MailStatusResponse.STATUS.ERROR.ordinal(), 
					mailData.getFrom(), mailData.getTo());
		}
		return new MailStatusResponse(MailStatusResponse.STATUS.OK.ordinal(), 
				mailData.getFrom(), mailData.getTo());
	}

}