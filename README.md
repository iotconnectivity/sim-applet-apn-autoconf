# sim-applet-apn-autoconf

JavaCard SIM card applet to configure a PDP Context with a correct APN via RUN AT proactive command


## Table of Contents

- [Description](#description)
- [To Do](#todo)
- [Installation and usage](#installation)
- [Contributing and license](#contributing)


## Description

Modems are configured by AT commands. The card application toolkit standard has a mechanism to send AT COMMANDS from the SIM card. See ["RUN AT COMMAND" ETSI TS 102.223](https://www.etsi.org/deliver/etsi_ts/102200_102299/102223/12.01.00_60/ts_102223v120100p.pdf).


The purpose of this applet is to configure an APN by sending AT commands from the SIM card.


## ToDo

- To find a device supports RUN AT COMMAND feature and test it.

## Installation

To install the applet you need:
- sysmoUSIM-SJS1 SIM + USIM Card with ADM1 key (find it here: http://shop.sysmocom.de/products/sysmousim-sjs1).
- a card reader.
- The scripts for installation are in the osmocom [repository] (http://git.osmocom.org/sim/sim-tools/) and you have a guide [here](https://osmocom.org/projects/sim-toolkit/wiki)


## Contributing

Please contribute using [Github Flow](https://guides.github.com/introduction/flow/). Create a branch, add commits, and [open a pull request](https://github.com/fraction/readme-boilerplate/compare/).

Please note this source code has been released under the GPLv3 terms and all contributions will be considered. Have a look at the LICENSE file distributed with this code.

## Standards

[AT command set for User Equipment](https://www.etsi.org/deliver/etsi_ts/127000_127099/127007/10.03.00_60/ts_127007v100300p.pdf)