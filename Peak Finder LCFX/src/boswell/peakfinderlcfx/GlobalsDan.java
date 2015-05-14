package boswell.peakfinderlcfx;

public class GlobalsDan
{
	public static double dRefColumnID = .21;
	public static double dRefColumnLength = 10;
	public static double dRefFlowRate = 0.4;
	
	// For a 2.1 x 100 mm column at 400 uL/min
	public static double[][] dDeadTimeArray = {
		 { 0.05, 0.5765467094},
		 { 0.1, 0.5580661923},
		 { 0.2, 0.5308528876},
		 { 0.3, 0.5111819018},
		 { 0.4, 0.4956178522},
		 { 0.5, 0.485146478},
		 { 0.6, 0.4854219833},
		 { 0.7, 0.4840580785},
		 { 0.8, 0.4895562191},
		 //{ 0.90, 0.48 } // This value is wrong.
		 { 0.95, 0.420572798} // What's up with this? Where's .90?
	};
	
	
	public static String[] strPredefinedValues = {
		"Yan 5 min gradient from 5% to 95%, 400 uL/min, 2.1 x 100 mm, lot B13101",
		"Yan 30 min gradient from 5% to 95%, 400 uL/min, 2.1 x 100 mm, lot B13101",
		"Yan 10 min gradient from 5% to 95%, 200 uL/min, 2.1 x 100 mm, lot B13101",
		"Yan 10 min gradient from 5% to 95%, 800 uL/min, 2.1 x 100 mm, lot B13101",
		"Dana method A",
		"Dana method B",
		"Dana method C",
		"Dana method D",
		"Emma A",
		"Emma B - remove benzamide",
		"Emma C",
		"Emma D",
		"Corey A - remove n-methyl acetamide",
		"Corey B - remove n-methyl acetamide",
		"Corey C - remove n-methyl acetamide",
		"Corey D - remove n-methyl acetamide",
		"David A",
		"David C",
		"David D",
		"Dwight A - last 4 benzamides might be bad",
		"Dwight B - last 4 benzamides might be bad",
		"Dwight C - last 4 benzamides might be bad",
		"Dwight D - last 4 benzamides might be bad",
		"Yamil A",
		"Yamil B",
		"Yamil C",
		"Yamil D",
		"Yan Method U3"
	};
	
	
	public static double[][][] dGradientPrograms = 
	{
		//innerdiameter,length, flowrate, instrumentdead time.
		{ // Yan 5 min gradient
			{2.1, 100, 0.4, 0.125},
			{0.0, 5.0}, //time, phi
			{5.0, 95.0},
			{10, 95}
		},
		{ // Yan 30 min
			{2.1, 100, 0.4, 0.125},
			{0, 5},
			{30, 95},
			{35, 95}
		},
		{ // Yan 10 min 0.2 ml/min
			{2.1, 100, 0.2, 0.25},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Yan 10 min 0.8 ml/min
			{2.1, 100, 0.8, 0.0625},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Dana method A
			{2.1, 100, 0.4, 0.11},
			{0, 5},
			{5, 95},
			{10, 95}
		},
		{ // Dana method B
			{2.1, 100, 0.4, 0.11},
			{0, 5},
			{30, 95},
			{35, 95}
		},
		{ // Dana method C
			{2.1, 100, 0.2, 0.22},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Dana method D
			{2.1, 100, 0.8, 0.055},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Emma method A
			{2.1, 100, 0.4, 0.08},
			{0, 5},
			{5, 95},
			{10, 95}
		},
		{ // Emma method B
			{2.1, 100, 0.4, 0.08},
			{0, 5},
			{30, 95},
			{35, 95}
		},
		{ // Emma method C
			{2.1, 100, 0.2, 0.16},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Emma method D
			{2.1, 100, 0.8, 0.04},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Corey A
			{2.1, 100, 0.4, 0.06},
			{0, 5},
			{5, 95},
			{10, 95}
		},
		{ // Corey B
			{2.1, 100, 0.4, 0.06},
			{0, 5},
			{30, 95},
			{35, 95}
		},
		{ // Corey C
			{2.1, 100, 0.2, 0.12},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Corey D
			{2.1, 100, 0.8, 0.03},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // David A
			{2.1, 100, 0.4, 0.09},
			{0, 5},
			{5, 95},
			{10, 95}
		},
		{ // David C
			{2.1, 100, 0.2, 0.18},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // David D
			{2.1, 100, 0.8, 0.045},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Dwight A
			{2.1, 100, 0.4, 0.125},
			{0, 5},
			{5, 95},
			{10, 95}
		},
		{ // Dwight B
			{2.1, 100, 0.4, 0.125},
			{0, 5},
			{30, 95},
			{35, 95}
		},
		{ // Dwight C
			{2.1, 100, 0.2, 0.25},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Dwight D
			{2.1, 100, 0.8, 0.0625},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Yamil A
			{2.1, 100, 0.4, 0.036},
			{0, 5},
			{5, 95},
			{10, 95}
		},
		{ // Yamil B
			{2.1, 100, 0.4, 0.036},
			{0, 5},
			{30, 95},
			{35, 95}
		},
		{ // Yamil C
			{2.1, 100, 0.2, 0.072},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Yamil D
			{2.1, 100, 0.8, 0.018},
			{0, 5},
			{10, 95},
			{15, 95}
		},
		{ // Yan Method U3
			{2.1, 100, 0.5, 0.1},
			{0, 5},
			{12, 98},
			{17, 98}
		},
		
	};
	
	// Enter the retention times of the standards here
	// 
	// The first part of the array lists the retention times (in min) of the back-calculation standards
	// The second part of the array lists the retention times (in min) of the test compounds, in the same order they are listed below
	// Important: if a retention time isn't available, just enter a zero ('0') in its place. 
	public static double[][][] dPredefinedValues = {
		{ // Yan A
			{
				0.805,
				1.140,
				1.685,
				1.983,
				2.186,
				2.572,
				3.019,
				3.480,
				3.888,
				4.259,
				4.607,
				4.936,
				5.247,
				5.541,
				5.814,
				6.084,
				6.400,
				6.788,
				7.266,
				7.873
			},
			{
				2.0782,
				2.7121,
				0.0,//2.9424, *This was not a good peak
				4.3445,
				4.6737,
				2.67,
				2.9505,
				4.7596,
				4.3445,
				3.3199,
				7.0576,
				2.9406,
				4.0651,
				5.9175,
				1.7943,
				2.9533,
				3.0082,
				2.9733,
				4.1542

			}
		},
		{ // Yan B
			{
				0.789,
				1.073,
				2.211,
				3.135,
				3.863,
				5.376,
				7.457,
				9.996,
				12.379,
				14.506,
				16.430,
				18.195,
				19.889,
				21.527,
				23.133,
				24.686,
				26.163,
				27.556,
				28.835,
				29.992
			},
			{
				3.620,
				4.318,
				0.000,
				13.526,
				16.617,
				6.229,
				8.116,
				17.365,
				13.534,
				10.974,
				28.509,
				8.373,
				16.044,
				24.071,
				3.262,
				8.897,
				9.129,
				8.988,
				15.179
			}
		},
		{ // Yan C
			{
				1.585,
				2.2392,
				3.3409,
				3.9474,
				4.3535,
				5.1285,
				6.026,
				6.9489,
				7.7649,
				8.5057,
				9.2011,
				9.8605,
				10.4872,
				11.0764,
				11.6214,
				12.1556,
				12.7868,
				13.5547,
				14.5115,
				0

			},
			{
				4.136,
				5.424,
				0.000,
				8.690,
				9.338,
				5.325,
				5.881,
				9.513,
				8.690,
				6.671,
				0.000,
				5.865,
				8.158,
				11.823,
				3.563,
				5.873,
				5.989,
				5.915,
				8.275
			}
		},
		{ // Yan D
			{
				0.407,
				0.578,
				1.093,
				1.460,
				1.738,
				2.295,
				3.038,
				3.911,
				4.718,
				5.437,
				6.086,
				6.693,
				7.275,
				7.837,
				8.379,
				8.897,
				9.374,
				9.828,
				10.231,
				10.603
			},
			{
				1.636,
				2.002,
				0.000,
				5.210,
				6.165,
				2.567,
				3.199,
				6.398,
				5.210,
				4.163,
				0.000,
				3.265,
				5.816,
				8.683,
				1.437,
				3.415,
				3.506,
				3.456,
				5.592
			}
		},
		{ // Dana A
			{
				0.779,
				1.114,
				1.966,
				2.302,
				2.520,
				2.912,
				3.344,
				3.795,
				4.202,
				4.572,
				4.917,
				5.246,
				5.560,
				5.861,
				6.163,
				6.490,
				6.874,
				7.344,
				7.910,
				8.615
			},
			{
				2.416,
				2.981,
				3.381,
				4.647,
				4.987,
				3.018,
				3.285,
				5.073,
				4.652,
				3.628,
				0.000,
				3.275,
				4.366,
				6.302,
				2.136,
				3.291,
				3.344,
				3.301,
				4.464

			}
		},
		{ // Dana B
			{
				0.776,
				1.127,
				2.469,
				3.453,
				4.237,
				5.768,
				7.879,
				10.435,
				12.831,
				14.941,
				16.861,
				18.638,
				20.339,
				21.975,
				23.564,
				25.125,
				26.600,
				27.960,
				29.229,
				30.427
			},
			{
				3.978,
				4.569,
				8.856,
				13.922,
				17.068,
				6.670,
				8.572,
				17.823,
				13.907,
				11.375,
				28.919,
				8.835,
				16.393,
				24.493,
				3.652,
				9.355,
				9.582,
				9.443,
				15.639
			}
		},
		{ // Dana C
			{
				1.382,
				2.161,
				3.9039,
				4.582,
				5.011,
				5.799,
				6.6926,
				7.5931,
				8.3924,
				9.1231,
				9.8141,
				10.4735,
				11.1104,
				11.736,
				12.3647,
				13.0383,
				13.7986,
				14.6983,
				14.9247,
				0.0
			},
			{
				4.803,
				5.984,
				6.745,
				9.299,
				9.959,
				6.010,
				6.558,
				10.117,
				9.299,
				7.277,
				0.000,
				6.558,
				8.729,
				12.668,
				4.262,
				6.558,
				6.670,
				6.600,
				8.901

			}
		},
		{ // Dana D
			{
				0.389,
				0.578,
				1.194,
				1.607,
				1.914,
				2.492,
				3.247,
				4.127,
				4.942,
				5.663,
				6.316,
				6.928,
				7.513,
				8.083,
				8.636,
				9.164,
				9.653,
				10.099,
				10.499,
				10.895
			},
			{
				1.800,
				2.094,
				3.556,
				5.399,
				6.410,
				2.799,
				3.432,
				6.649,
				5.399,
				4.374,
				0.000,
				3.485,
				6.030,
				8.946,
				1.631,
				3.648,
				3.730,
				3.676,
				5.839

			}
		},
		{ // Emma A
			{
				0.7542,
				1.0684,
				2.0833,
				0.0000,
				2.6985,
				3.1081,
				3.5636,
				4.06,
				4.507,
				4.8967,
				5.2636,
				5.6198,
				5.9645,
				6.3049,
				6.6577,
				7.0492,
				7.4979,
				8.0321,
				8.6682,
				9.4548
			},
			{
				2.5857,
				3.1161,
				0,
				4.9782,
				5.3522,
				3.2305,
				3.5122,
				5.4429,
				0,
				3.8684,
				0,
				3.5036,
				4.6669,
				6.8315,
				2.3272,
				3.5068,
				3.5603,
				3.5166,
				4.7918

			}
		},
		{ // Emma B
			{
				0.7506,
				1.0599,
				2.4134,
				0,
				4.2608,
				5.7818,
				7.8495,
				10.3823,
				12.7632,
				14.8775,
				16.8599,
				18.8308,
				20.6476,
				22.3599,
				24.016,
				25.6235,
				27.1344,
				28.5781,
				29.9179,
				31.1739

			},
			{
				3.967,
				4.501,
				8.930,
				0.000,
				17.136,
				6.733,
				8.560,
				17.998,
				0.000,
				11.179,
				0.000,
				8.810,
				16.110,
				25.007,
				3.717,
				9.292,
				9.525,
				9.370,
				15.567

			}
		},
		{ // Emma C
			{
				1.509,
				2.099,
				4.032,
				4.752,
				5.180,
				6.006,
				6.962,
				7.970,
				8.872,
				9.662,
				10.425,
				11.169,
				11.893,
				12.610,
				13.346,
				14.173,
				15.134,
				16.244,
				17.611,
				0.0//18.391
			},
			{
				4.995,
				6.090,
				7.072,
				0.000,
				10.589,
				6.236,
				6.805,
				10.805,
				0.000,
				7.598,
				0.000,
				6.822,
				9.202,
				13.744,
				4.443,
				6.822,
				6.943,
				6.840,
				9.434

			}
		},
		{ // Emma D
			{
				0.376,
				0.547,
				1.255,
				1.740,
				2.042,
				2.624,
				3.383,
				4.239,
				5.037,
				5.760,
				6.464,
				7.099,
				7.716,
				8.290,
				8.860,
				9.400,
				9.873,
				10.371,
				10.799,
				11.252
			},
			{
				1.909,
				2.167,
				3.719,
				0.000,
				6.607,
				2.960,
				0.000,
				6.839,
				17.561,
				4.408,
				0.000,
				3.607,
				6.064,
				9.175,
				1.771,
				3.736,
				3.822,
				3.753,
				5.951

			}
		},
		{ // Corey A - Replaced these with the retention times from the second file.
			{
				0,
				1.0114,
				1.4369,
				1.717,
				1.9102,
				2.2809,
				2.7171,
				3.1754,
				3.5887,
				3.9678,
				4.3283,
				4.6755,
				5.0069,
				5.3214,
				5.6154,
				5.8945,
				6.1953,
				6.557,
				7.009,
				7.5843
			},
			{
				1.8015,
				2.2757,
				2.7513,
				4.0269,
				4.4026,
				2.3741,
				2.6515,
				4.4951,
				0.0,
				2.9924,
				6.8105,
				2.6414,
				3.7233,
				5.734,
				1.5161,
				2.6523,
				2.7079,
				2.6681,
				3.8669
			}
		},
		{ // Corey B
			{
				0,
				1.0533,
				2.0769,
				2.9444,
				3.6296,
				5.0687,
				7.0925,
				9.5903,
				11.9693,
				14.094,
				16.0076,
				17.7862,
				19.4854,
				21.1392,
				22.7542,
				24.3244,
				25.8262,
				27.2396,
				28.544,
				29.733
			},
			{
				3.381,
				3.720,
				0.000,
				0.000,
				16.199,
				5.869,
				7.751,
				16.960,
				0.000,
				10.427,
				28.217,
				7.997,
				15.337,
				23.708,
				2.997,
				8.517,
				8.751,
				8.605,
				14.798

			}
		},
		{ // Corey C
			{
				0,
				2.0036,
				2.8731,
				3.4331,
				3.8198,
				4.5623,
				5.4403,
				6.3597,
				7.1857,
				7.9408,
				8.6512,
				9.3341,
				9.9922,
				10.6199,
				11.2116,
				11.7727,
				12.3671,
				13.0924,
				13.9865,
				15.1332
			},
			{
				3.6063,
				4.6009,
				5.4992,
				8.0842,
				8.7963,
				4.7446,
				5.2983,
				8.9738,
				8.0753,
				5.971,
				13.595,
				5.2835,
				7.4278,
				11.454,
				3.0272,
				5.295,
				5.4046,
				5.3244,
				7.7228

			}
		},
		{ // Corey D
			{
				0,
				0.5283,
				0.9722,
				1.3256,
				1.5884,
				2.1232,
				2.8495,
				3.7111,
				4.5136,
				5.2289,
				5.8833,
				6.4941,
				7.079,
				7.6478,
				8.1993,
				8.726,
				9.2248,
				9.6871,
				10.1074,
				10.4882
			},
			{
				1.479,
				1.691,
				3.134,
				0.000,
				5.968,
				2.388,
				3.017,
				6.212,
				0.000,
				3.905,
				9.996,
				3.077,
				5.509,
				8.509,
				1.286,
				3.236,
				3.320,
				3.268,
				5.406

			}
		},
		{ // David A
			{
				0.7601,
				1.0688,
				1.502,
				1.7817,
				1.9783,
				2.3516,
				2.7897,
				3.2551,
				3.6749,
				4.0564,
				4.4135,
				4.7518,
				5.0764,
				5.3808,
				5.6622,
				5.9214,
				6.21,
				6.5642,
				7.0092,
				7.5694
			},
			{
				1.8726553,
				2.528419865,
				2.822211948,
				4.144277943,
				4.49,
				2.447352779,
				2.723441398,
				4.57248279,
				4.144773696,
				3.124032136,
				0,
				2.716939642,
				3.902948879,
				5.77526471,
				1.582111931,
				2.72771856,
				2.78150312,
				2.747135729,
				3.95375817

			}
		},
		
		{ // David C
			{
				1.5018,
				2.1052,
				3.0073,
				3.5687,
				3.9598,
				4.7059,
				5.5837,
				6.5158,
				7.3489,
				8.1076,
				8.8142,
				9.4877,
				10.132,
				10.7418,
				11.3089,
				11.8291,
				12.4068,
				13.1128,
				14.0002,
				0.0
			},
			{
				3.750,
				5.063,
				5.638,
				8.293,
				8.957,
				4.895,
				5.442,
				9.130,
				8.291,
				6.238,
				0.000,
				5.425,
				7.773,
				11.534,
				3.165,
				5.440,
				5.548,
				5.472,
				7.887

			}
		},
		{ // David D
			{
				0.3906,
				0.5521,
				1.008,
				1.3591,
				1.6247,
				2.1631,
				2.8918,
				3.7538,
				4.5584,
				5.272,
				5.9263,
				6.5394,
				7.1225,
				7.6919,
				8.241,
				8.7647,
				9.251,
				9.7089,
				10.119,
				10.4949,
			},
			{
				1.517,
				1.884,
				3.165,
				5.030,
				6.009,
				2.432,
				3.054,
				6.250,
				5.038,
				4.003,
				0.000,
				3.115,
				5.660,
				8.547,
				1.316,
				3.272,
				3.357,
				3.304,
				5.445

			}
		},
		{ // Dwight A
			{
				0.8175,
				1.1327,
				1.6047,
				1.891,
				2.095,
				2.4741,
				2.926,
				3.3757,
				3.7847,
				4.1541,
				4.4998,
				4.8268,
				5.1371,
				5.4291,
				5.7015,
				5.9643,
				6.2744,
				6.6538,
				7.1204,
				7.7203
			},
			{
				1.99,
				2.626,
				0,
				4.241,
				4.567,
				0,
				2.862,
				4.6534,
				4.241,
				3.133,
				0,
				2.821,
				3.848,
				5.8,
				1.689,
				2.865,
				2.9,
				2.878,
				4.05,

			}
		},
		{ // Dwight B
			{
				0.8146,
				1.1529,
				2.2337,
				3.1243,
				3.839,
				5.3169,
				7.3826,
				9.9046,
				12.2911,
				14.4084,
				16.3278,
				18.1004,
				19.7956,
				21.4331,
				23.0304,
				24.5733,
				26.0468,
				0.0,
				0.0,
				0.0
			},
			{
				3.597,
				4.276,
				0,
				13.428,
				16.499,
				0,
				8.028,
				17.265,
				13.431,
				10.52,
				0,
				8.282,
				15.411,
				23.964,
				3.188,
				8.809,
				9.0455,
				8.903,
				15.089

			}
		},
		{ // Dwight C
			{
				1.6117,
				2.2442,
				3.1891,
				3.7663,
				4.1709,
				4.9332,
				5.8315,
				6.7319,
				7.5501,
				8.2888,
				8.9849,
				9.6417,
				10.2649,
				10.8515,
				11.3912,
				11.9141,
				12.5286,
			},
			{
				3.956,
				5.242,
				0,
				0,
				9.13,
				0,
				0,
				9.293,
				8.474,
				6.241,
				0,
				0,
				7.677,
				11.594,
				3.36,
				5.7,
				5.766,
				5.724,
				8.066

			}
		},
		{ // Dwight D
			{
				0.4083,
				0.5782,
				1.0623,
				1.4232,
				1.7,
				2.2532,
				2.9934,
				3.8643,
				4.6719,
				5.3885,
				6.0402,
				6.6487,
				7.2278,
				7.7869,
				8.3259,
				8.8404,
				9.3218,
				9.7667,
				10.1688,
				10.5375
			},
			{
				1.594,
				1.947,
				0,
				5.154,
				6.118,
				0,
				3.151,
				6.358,
				5.154,
				3.983,
				0,
				3.212,
				5.584,
				8.629,
				1.385,
				3.375,
				3.461,
				3.411,
				5.549

			}
		},
		{ // Yamil A
			{
				0.7449,
				1.0583,
				1.5837,
				1.8888,
				2.0887,
				2.4688,
				2.92,
				3.3748,
				3.7873,
				4.1601,
				4.5089,
				4.8377,
				5.1514,
				5.4473,
				5.7237,
				5.9943,
				6.3171,
				6.7167,
				7.2113,
				7.8432,
			},
			{
				1.974,
				2.6212,
				2.9405,
				4.2469,
				4.5742,
				2.5576,
				2.8401,
				4.6591,
				4.2468,
				3.1825,
				7.0368,
				2.8285,
				3.9466,
				5.8325,
				1.6713,
				2.8331,
				2.8942,
				2.858,
				4.0457


			}
		},
		{ // Yamil B
			{
				0.7376,
				1.0498,
				2.1444,
				3.0652,
				3.7817,
				5.2703,
				7.3466,
				9.8841,
				12.282,
				14.4087,
				16.3327,
				18.112,
				19.813,
				21.4601,
				23.0688,
				24.6209,
				26.1041,
				27.4964,
				28.7783,
				29.9363,
			},
			{
				3.5546,
				4.1786,
				8.3489,
				13.348,
				16.539,
				6.1258,
				8.0678,
				17.284,
				13.365,
				10.831,
				28.458,
				8.3003,
				15.835,
				24.011,
				3.1764,
				8.8644,
				9.0982,
				9.0098,
				15.072

			}
		},
		{ // Yamil C
			{
				1.468,
				2.083,
				3.135,
				3.746,
				4.1461,
				4.908,
				5.805,
				6.722,
				7.542,
				8.288,
				8.985,
				9.645,
				10.277,
				10.872,
				11.426,
				11.964,
				12.6136,
				13.403,
				14.37,
				15.623
			},
			{
				3.9176,
				5.2305,
				5.8407,
				8.4652,
				9.1153,
				5.0811,
				5.6395,
				9.2848,
				8.4646,
				6.3209,
				14.026,
				5.6143,
				7.8431,
				11.641,
				3.3005,
				5.6203,
				5.7436,
				5.6698,
				8.0506

			}
		},
		{ // Yamil D
			{
				0.3749,
				0.5419,
				1.0413,
				1.4112,
				1.6882,
				2.2447,
				2.9874,
				3.8618,
				4.6679,
				5.383,
				6.0362,
				6.6425,
				7.225,
				7.7877,
				8.3293,
				8.8447,
				9.3285,
				9.778,
				10.1772,
				10.5525,
			},
			{
				1.5889,
				1.8957,
				3.2866,
				5.139,
				6.1242,
				2.5218,
				3.1707,
				6.3611,
				5.1388,
				4.1011,
				10.071,
				3.2286,
				5.7334,
				8.6344,
				1.4032,
				3.3879,
				3.4708,
				3.4405,
				5.5395

			}
		},
		{ // Yan Method U3
			{
				0.7981,
				1.129,
				1.9556,
				2.4899,
				2.8634,
				3.6022,
				4.5354,
				5.5708,
				6.5032,
				7.3359,
				8.0983,
				8.8186,
				9.5109,
				10.1787,
				10.8132,
				11.4055,
				11.9498,
				12.4369,
				12.8783,
				13.3246
			},
			{
				2.6984,
				3.4085,
				0,
				7.2709,
				8.2296,
				3.8914,
				4.5903,
				8.4705,
				7.2711,
				5.6264,
				0,
				4.6312,
				7.4287,
				11.151,
				2.3313,
				4.7437,
				4.8515,
				4.7798,
				7.3501
			}
		},
	};
	
	public static String[] StationaryPhaseArray = {
		"Agilent Eclipse Plus C18 (3.5 \u00b5m particle size)"
		};
		
		public static String[] StandardCompoundsNameArray = {
			"N-methylacetamide",
			"N-ethylacetamide",
			"N,N-dimethylpropionamide",
			"benzamide",
			"N-methylbenzamide",
			"N-ethylbenzamide",
			"N-propylbenzamide",
			"N-butylbenzamide",
			"N-pentylbenzamide",
			"N-hexylbenzamide",
			"N-heptylbenzamide",
			"N-octylbenzamide",
			"N-nonylbenzamide",
			"N-decylbenzamide",
			"N-undecylbenzamide",
			"N-dodecylbenzamide",
			"N-tridecylbenzamide",
			"N-tetradecylbenzamide",
			"N-pentadecylbenzamide",
			"N-hexadecylbenzamide"
		};
		
		public static double[][] StandardCompoundsMZArray = {
			{74.06059},
			{88.07624},
			{102.09189},
			{122.06059},
			{136.07624},
			{150.09189},
			{164.10754},
			{178.12319},
			{192.13884},
			{206.15449},
			{220.17014},
			{234.18579},
			{248.20144},
			{262.21709},
			{276.23274},
			{290.24839},
			{304.26404},
			{318.27969},
			{332.29534},
			{346.31099}
		};
		
		public static double[][][] StandardIsocraticDataArray = {
			//{{ .95, -10}, {.05, -10}}, 
			{{ .9, -1.5696378176}, { .8, -1.5245677987}, { .7, -1.5604804034}, { .6, -1.5615156587}, { .5, -1.577842916}, { .4, -1.467212992}, { .3, -1.4350636584}, { .2, -1.3029330444}, { .1, -.9963715547}, { .05, -.6817223081}},
			{{ .9, -1.0767345329}, { .8, -1.0642852147}, { .7, -1.0658242849}, { .6, -1.0544705612}, { .5, -1.0650657207}, { .4, -.9479194937}, { .3, -.8521794343}, { .2, -.6838532153}, { .1, -.3950652061}, { .05, -.0962377451}},
			{{ .9, -.7820500842}, { .8, -.8094914006}, { .7, -.7881691093}, { .6, -.7466197803}, { .5, -.7023625844}, { .4, -.5975732984}, { .3, -.4628915227}, { .2, -.2199069523}, { .1, .2160936095}, { .05, .577602594}},
			{{ .9, -.9807011041}, { .8, -.906951425}, { .7, -.8493162297}, { .6, -.7394661279}, { .5, -.6175833415}, { .4, -.4618448583}, { .3, -.2570309245}, { .2, .0592113446}, { .1, .5299288753}, { .05, .8491081146}},
			{{ .9, -.8253251811}, { .8, -.7804105937}, { .7, -.6780081505}, { .6, -.5693049364}, { .5, -.4576315557}, { .4, -.2889254429}, { .3, -.0757041251}, { .2, .2365717704}, { .1, .7156273044}, { .05, 1.0639431319}},
			{{ .9, -.692563849}, { .8, -.6385030356}, { .7, -.5367410102}, { .6, -.3959776778}, { .5, -.2429027444}, { .4, -.0421582431}, { .3, .2009837763}, { .2, .5416526718}, { .1, 1.0490851524}, { .05, 1.4234071543}},
			{{ .9, -.6160657006}, { .8, -.5323669699}, { .7, -.3936274301}, { .6, -.2270179174}, { .5, -.0325760125}, { .4, .2043121794}, { .3, .5015682521}, { .2, .8952221427}, { .1, 1.4614186663}},
			{{ .9, -.5430003341}, { .8, -.413973791}, { .7, -.2408279897}, { .6, -.0425894982}, { .5, .1868901749}, { .4, .4783541215}, { .3, .8416830981}, { .2, 1.3160436961}},
			{{ .9, -.4357234103}, { .8, -.2864996887}, { .7, -.087627182}, { .6, .1419160965}, { .5, .4103310528}, { .4, .7551699934}, { .3, 1.1921648193}},
			{{ .9, -.3413615141}, { .8, -.1525561164}, { .7, .0734287176}, { .6, .3284463934}, { .5, .6349984855}, { .4, 1.0348127974}, { .3, 1.5477202356}},
			{{ .9, -.2236962522}, { .8, -.0085506598}, { .7, .2357928918}, { .6, .5201104753}, { .5, .8640757708}, { .4, 1.3169133329}},
			{{ .9, -.1079219651}, { .8, .1334648551}, { .7, .4033947883}, { .6, .7146566305}, { .5, 1.0942207349}, { .4, 1.6000459568}},
			{{ .9, .0112571978}, { .8, .2797082283}, { .7, .5742782561}, { .6, .9123485721}, { .5, 1.3268497657}},
			{{ .9, .1357240009}, { .8, .4286480716}, { .7, .7476710957}, { .6, 1.1118138649}, { .5, 1.5608404988}},
			{{ .9, .259012992}, { .8, .581167295}, { .7, .9237731396}, { .6, 1.31319561}},
			{{ .9, .3872521779}, { .8, .7351124195}, { .7, 1.1001709578}, { .6, 1.5162804061}},
			{{ .9, .5128216913}, { .8, .8888308836}, { .7, 1.2785275011}},
			{{ .9, .6431684874}, { .8, 1.0452241402}, { .7, 1.4610367404}},
			{{ .9, .7722474525}, { .8, 1.2019166982}},
			{{ .9, .9019256312}, { .8, 1.3597640716}}
		};
		
		public static String[] TestCompoundNameArray = {
			"N,N-diethylacetamide",
			"N-allyl aniline",
			"1,3-naphthalenediol",
			"p-coumaric acid",
			"diphenylamine",
			"7-amino-4-methylcoumarin",
			"naphthalene acetamide",
			"2-phenylindole",
			"anilinoacetaldehyde diethyl acetal",
			"tetrabutylammonium",
			"dodecanophenone",
			"abscisic acid",
			"tetrapentylammonium",
			"di-n-pentyl phthalate",
			"chlorogenic acid",
			"prednisone",
			"cortisone",
			"hydrocortisone",
			"curcumin"
		};
		
		public static double[][] TestCompoundMZArray = {
			{116.10754},
			{134.09697},
			{161.06026},
			{165.05517},
			{170.09697},
			{176.04460}, // methyl amino coumarin
			{186.09189},
			{194.09697},
			{210.14940},
			{242.28423}, // tetrabutylammonium
			{261.22184}, // dodecanophenone
			{265.14398}, // abscisic acid
			{298.34683}, // tetrapentylammonium
			{307.19093}, // di-n-pentyl phthalate
			{355.10291}, // chlorogenic acid
			{359.18585}, // prednisone
			{361.20150}, // cortisone
			{363.21715}, // hydrocortisone
			{369.13381}, // curcumin
		};
		
		public static double[][][] TestCompoundsIsocraticDataArray = {
			{{ .9069281682, -.8795088967}, { .8024476487, -.848628676}, { .7026600699, -.7798225859}, { .603097122, -.668939247}, { .5027039615, -.5679624051}, { .4028808372, -.4079733719}, { .3015634585, -.2051743762}, { .2005313955, .1224047779}, { .0996259045, .6517235918}, { .0494409457, 1.0512502752}},
			{{ .9069281682, -.41}, { .8024476487, -.25}, { .7026600699, -.0938779748}, { .603097122, .0643510037}, { .5027039615, .1856720577}, { .4028808372, .2877617665}, { .3015634585, .3949495723}, { .2005313955, .5356255303}, { .0996259045, .8019045895}, { .0494409457, 1.0389345783}},
			{{ .9069281682, -1.0774372875}, { .8024476487, -.8368772694}, { .7026600699, -.5855206601}, { .603097122, -.3683622807}, { .5027039615, -.1589789055}, { .4028808372, .1552005778}, { .3015634585, .5385835314}, { .2005313955, 1.0663294302}},
			{{ .965, -.3794473773}, { .9069281682, -.2774892455}, { .8024476487, -.0508571316}, { .7026600699, .1730621906}, { .603097122, .4112278261}, { .5027039615, .6783018443}, { .4028808372, .9779185038}, { .3015634585, 1.3069602276}, { .2005313955, 1.706761}},
			{{ .9069281682, -.3041243196}, { .8024476487, -.0175630621}, { .7026600699, .2617998254}, { .603097122, .5581471193}, { .5027039615, .8977808647}, { .4028808372, 1.3289154703}},
			{{ .9069281682, -.9523561594}, { .8024476487, -.8057269452}, { .7026600699, -.635328459}, { .603097122, -.4481805763}, { .5027039615, -.2729450948}, { .4028808372, -.053304428}, { .3015634585, .229814269}, { .2005313955, .6423669581}, { .0996259045, 1.2847073621}},
			{{ .9069281682, -.8993848991}, { .8024476487, -.7365478579}, { .7026600699, -.582798605}, { .603097122, -.4033135782}, { .5027039615, -.19}, { .4028808372, .0744141856}, { .3015634585, .4515891898}, { .2005313955, 1.0135844323}},
			{{ .9069281682, -.2883297557}, { .8024476487, -.0007656566}, { .7026600699, .2946296276}, { .603097122, .6106907577}, { .5027039615, .9745816781}, { .4028808372, 1.4497712765}},
			{{ .9069281682, -.25461963}, { .8024476487, -.05}, { .7026600699, .1685989127}, { .603097122, .4127587048}, { .5027039615, .677170893}, { .4028808372, .9727993411}, { .3015634585, 1.3115873541}, { .20053, 1.72135}},
			{{ .603097122, -.829442735}, { .5027039615, -.2574938872}, { .4028808372, .3600501}, { .3015634585, .9391708563}, { .2005313955, 1.5825541519}},
			{{ .965, .45}, { .9069281682, .7}, { .8024476487, 1.14}, { .7026600699, 1.58}},
			{{ .9069281682, -1.1147538646}, { .8024476487, -.926615346}, { .7026600699, -.6985825388}, { .603097122, -.4780674386}, { .5027039615, -.2695158955}, { .4028808372, .0432015756}, { .3015634585, .4440761463}, { .2005313955, 1.0679757067}},
			{{ .7026600699, -.7295940774}, { .603097122, -.0061703343}, { .5027039615, .6}, { .4028808372, 1.3229594857}},
			{{ .965, .052125322}, { .9069281682, .2670691351}, { .8024476487, .6485340662}, { .7026600699, 1.0193469305}, { .603097122, 1.4260620235}},
			{{ .2005313955, -.4}, { .0996259045, .4880459472}, {0.049441, 1.14}},
			{{ .9069281682, -.9380454232}, { .8024476487, -.86}, { .7026600699, -.7282956988}, { .603097122, -.5446329108}, { .5027039615, -.315}, { .4028808372, .0035908249}, { .3015634585, .4734749876}, { .2005313955, 1.2429121735}},
			{{ .9069281682, -.8956261814}, { .8024476487, -.7871279681}, { .7026600699, -.6501545516}, { .603097122, -.475}, { .5027039615, -.26}, { .4028808372, .0629926124}, { .3015634585, .5275748091}, { .2005313955, 1.3028813153}},
			{{ .9069281682, -.8224965796}, { .8024476487, -.7}, { .7026600699, -.6352314873}, { .603097122, -.5038667915}, { .5027039615, -.3}, { .4028808372, .0185888002}, { .3015634585, .51}, { .2005313955, 1.2744464502}},
			{{ .9069281682, -.7165521618}, { .8024476487, -.4346436523}, { .7026600699, -.1458461689}, { .603097122, .1849818309}, { .5027039615, .59}, { .4028808372, 1.1163692501}},
			
		};
		
		public static String[] OtherCompoundsNameArray = {
			"N,N-diethylacetamide",
			"N-allyl aniline",
			"1,3-naphthalenediol",
			"p-coumaric acid",
			"diphenylamine",
			"7-amino-4-methylcoumarin",
			"naphthalene acetamide",
			"2-phenylindole",
			"anilinoacetaldehyde diethyl acetal",
			"tetrabutylammonium",
			"dodecanophenone",
			"abscisic acid",
			"tetrapentylammonium",
			"di-n-pentyl phthalate",
			"chlorogenic acid",
			"prednisone",
			"cortisone",
			"hydrocortisone",
			"curcumin"
		};

		public static double[][][] OtherCompoundsIsocraticDataArray = {
			{{ .9069281682, -.8795088967}, { .8024476487, -.848628676}, { .7026600699, -.7798225859}, { .603097122, -.668939247}, { .5027039615, -.5679624051}, { .4028808372, -.4079733719}, { .3015634585, -.2051743762}, { .2005313955, .1224047779}, { .0996259045, .6517235918}, { .0494409457, 1.0512502752}},
			{{ .9069281682, -.41}, { .8024476487, -.25}, { .7026600699, -.0938779748}, { .603097122, .0643510037}, { .5027039615, .1856720577}, { .4028808372, .2877617665}, { .3015634585, .3949495723}, { .2005313955, .5356255303}, { .0996259045, .8019045895}, { .0494409457, 1.0389345783}},
			{{ .9069281682, -1.0774372875}, { .8024476487, -.8368772694}, { .7026600699, -.5855206601}, { .603097122, -.3683622807}, { .5027039615, -.1589789055}, { .4028808372, .1552005778}, { .3015634585, .5385835314}, { .2005313955, 1.0663294302}},
			{{ .965, -.3794473773}, { .9069281682, -.2774892455}, { .8024476487, -.0508571316}, { .7026600699, .1730621906}, { .603097122, .4112278261}, { .5027039615, .6783018443}, { .4028808372, .9779185038}, { .3015634585, 1.3069602276}, { .2005313955, 1.706761}},
			{{ .9069281682, -.3041243196}, { .8024476487, -.0175630621}, { .7026600699, .2617998254}, { .603097122, .5581471193}, { .5027039615, .8977808647}, { .4028808372, 1.3289154703}},
			{{ .9069281682, -.9523561594}, { .8024476487, -.8057269452}, { .7026600699, -.635328459}, { .603097122, -.4481805763}, { .5027039615, -.2729450948}, { .4028808372, -.053304428}, { .3015634585, .229814269}, { .2005313955, .6423669581}, { .0996259045, 1.2847073621}},
			{{ .9069281682, -.8993848991}, { .8024476487, -.7365478579}, { .7026600699, -.582798605}, { .603097122, -.4033135782}, { .5027039615, -.19}, { .4028808372, .0744141856}, { .3015634585, .4515891898}, { .2005313955, 1.0135844323}},
			{{ .9069281682, -.2883297557}, { .8024476487, -.0007656566}, { .7026600699, .2946296276}, { .603097122, .6106907577}, { .5027039615, .9745816781}, { .4028808372, 1.4497712765}},
			{{ .9069281682, -.25461963}, { .8024476487, -.05}, { .7026600699, .1685989127}, { .603097122, .4127587048}, { .5027039615, .677170893}, { .4028808372, .9727993411}, { .3015634585, 1.3115873541}, { .20053, 1.72135}},
			{{ .603097122, -.829442735}, { .5027039615, -.2574938872}, { .4028808372, .3600501}, { .3015634585, .9391708563}, { .2005313955, 1.5825541519}},
			{{ .965, .45}, { .9069281682, .7}, { .8024476487, 1.14}, { .7026600699, 1.58}},
			{{ .9069281682, -1.1147538646}, { .8024476487, -.926615346}, { .7026600699, -.6985825388}, { .603097122, -.4780674386}, { .5027039615, -.2695158955}, { .4028808372, .0432015756}, { .3015634585, .4440761463}, { .2005313955, 1.0679757067}},
			{{ .7026600699, -.7295940774}, { .603097122, -.0061703343}, { .5027039615, .6}, { .4028808372, 1.3229594857}},
			{{ .965, .052125322}, { .9069281682, .2670691351}, { .8024476487, .6485340662}, { .7026600699, 1.0193469305}, { .603097122, 1.4260620235}},
			{{ .2005313955, -.4}, { .0996259045, .4880459472}, {0.049441, 1.14}},
			{{ .9069281682, -.9380454232}, { .8024476487, -.86}, { .7026600699, -.7282956988}, { .603097122, -.5446329108}, { .5027039615, -.315}, { .4028808372, .0035908249}, { .3015634585, .4734749876}, { .2005313955, 1.2429121735}},
			{{ .9069281682, -.8956261814}, { .8024476487, -.7871279681}, { .7026600699, -.6501545516}, { .603097122, -.475}, { .5027039615, -.26}, { .4028808372, .0629926124}, { .3015634585, .5275748091}, { .2005313955, 1.3028813153}},
			{{ .9069281682, -.8224965796}, { .8024476487, -.7}, { .7026600699, -.6352314873}, { .603097122, -.5038667915}, { .5027039615, -.3}, { .4028808372, .0185888002}, { .3015634585, .51}, { .2005313955, 1.2744464502}},
			{{ .9069281682, -.7165521618}, { .8024476487, -.4346436523}, { .7026600699, -.1458461689}, { .603097122, .1849818309}, { .5027039615, .59}, { .4028808372, 1.1163692501}},
			
		};
	
	
	public static double roundToSignificantFigures(double num, int n) 
	{
	    if (num == 0) 
	    {
	        return 0;
	    }

	    final double d = Math.ceil(Math.log10(num < 0 ? -num: num));
	    final int power = n - (int) d;

	    final double magnitude = Math.pow(10, power);
	    final long shifted = Math.round(num * magnitude);
	    
	    return shifted / magnitude;
	}
	
	public static String convertMZToString(double[] mzValues)
	{
		String str = "";
		for (int j = 0; j < mzValues.length; j++)
		{
			str += mzValues[j];
			if (j < mzValues.length - 1)
				str += ", ";
		}
		
		return str;
	}
}
