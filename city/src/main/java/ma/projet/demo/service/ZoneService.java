package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import ma.projet.demo.entities.Zone;
import ma.projet.demo.repository.ZoneRepository;

@Service
public class ZoneService {

	@Autowired
	private ZoneRepository zoneRepository;

	public List<Zone> getAllZones() {
		return zoneRepository.findAll();
	}

	public List<Zone> getZonesByCityId(Long cityId) {
		return zoneRepository.findByCityId(cityId);
	}

	public Zone getZoneById(Long id) {
		return zoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Zone not found with id " + id));
	}

	public Zone createZone(Zone zone) {
		return zoneRepository.save(zone);
	}

	public Zone updateZone(Long id, Zone zoneDetails) {
		Zone zone = zoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Zone not found with id " + id));
		zone.setName(zoneDetails.getName());
		zone.setCity(zoneDetails.getCity());
		return zoneRepository.save(zone);
	}

	public void deleteZone(Long id) {
		Zone zone = zoneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Zone not found with id " + id));
		zoneRepository.delete(zone);
	}
}
