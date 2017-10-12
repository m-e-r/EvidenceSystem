
using System;
using System.Web.Services;


[WebService (Namespace = "localhost")]
public class MathService : WebService
{
	[WebMethod]
	public int AddNumbers (int number1, int number2)
	{
		return number1 + number2;
	}

	[WebMethod]
	public int SubtractNumbers (int number1, int number2)
	{
		return number1 - number2;
	}
}

