package org.monarchnc.servlets.async;

import java.io.IOException;
import java.io.Writer;

import javax.persistence.PersistenceContext;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@WebServlet(value = "/public/example", asyncSupported = true)
public class AsyncExampleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	
	//	final AsyncContext asyncContext = req.startAsync(req, res);
	//	asyncContext.getResponse().getWriter().println("Start");
	//	asyncContext.start(new Foo(asyncContext));
	}

	private class Foo implements Runnable {
		AsyncContext asyncContext;

		public Foo(AsyncContext asyncContext) {
			this.asyncContext = asyncContext;
		}

		@Override
		public void run() {
			String fooTicker = "GOOG";
			Double price = 0d;
			try {
				asyncContext.getResponse().getWriter()
						.printf("ticker: %s, price: %.2f", fooTicker, price);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				asyncContext.complete();
			}
		}
	}
}
