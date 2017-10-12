using System;
using System.Data.SqlClient;
using Npgsql;
using System.Data;

namespace SemesterProjektE17Server
{
	class MainClass
	{
		private static string server = "tek-mmmi-db0a.tek.c.sdu.dk";
		private static string port = "5432";
		private static string userId = "si3_2017_group_13";
		private static string passWord = "grim26:bijou";
		private static string database = "si3_2017_group_13_db";

		public static void Main (string[] args)
		{
			MathService ms = new MathService ();
			ms.AddNumbers (6, 8);

			try {
				// PostgeSQL-style connection string
				string connstring = String.Format ("Server={0};Port={1};" +
				                    "User Id={2};Password={3};Database={4};",
					                    server, port, userId, 
					                    passWord, database);
				// Making connection with Npgsql provider
				NpgsqlConnection conn = new NpgsqlConnection (connstring);
				conn.Open ();

				string sql = "SELECT * FROM simple_table";
				// data adapter making request from our connection
				NpgsqlCommand da = new NpgsqlCommand (sql, conn);
				// i always reset DataSet before i do
				// something with it.... i don't know why :-)
				NpgsqlDataReader dr = da.ExecuteReader ();

				// Output rows
				while (dr.Read ())
					Console.Write ("{0}\t{1} \n", dr [0], dr [1]);

				// since we only showing the result we don't need connection anymore
				conn.Close ();
			} catch (Exception msg) {
				// something went wrong, and you wanna know why
				Console.WriteLine (msg);
			}
		
		}
	}
}
