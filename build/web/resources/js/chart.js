/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


		var options = {
				bullion: 'gold',
				currency: 'USD',
				timeframe: '1w',
				chartType: 'line',
				miniChartModeAxis : 'oz',
				referrerID: 'MYUSERNAME',
				containerDefinedSize: true,
				miniChartMode: false,
				displayLatestPriceLine: true,
				switchBullion: true,
				switchCurrency: true,
				switchTimeframe: true,
				switchChartType: false,
				exportButton: false
			};
			var chartBV = new BullionVaultChart(options, 'embed');